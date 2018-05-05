import time, sys, cherrypy, os
from paste.translogger import TransLogger
from webapp import create_app
from pyspark import SparkContext, SparkConf
path = "/Users/luo/Desktop/github/Spark_Movie_recsys/engine1"
sys.path.append(path)
#sys.path.append("/Users/luo/Desktop/github/Spark_Movie_recsys/engine1")
def init_spark_context():
    # load spark context
    conf = SparkConf().setAppName("movie_recommendation-server").setMaster("spark://luodeMacBook-Pro.local:7077").set("spark.driver.allowMultipleContexts", "true").set("spark.executor.memory", "512m").set("spark.cores.max","3")
    # IMPORTANT: pass aditional Python modules to each worker
    # sc = SparkContext(conf=conf, pyFiles=['rec_engine.py', 'app.py'])
    sc = SparkContext(conf=conf,pyFiles=['engine1/rec_engine.py'])
 
    return sc
 
 
def run_server(app): 
    # Enable WSGI access logging via Paste
    app_logged = TransLogger(app)
 
    # Mount the WSGI callable object (app) on the root directory
    cherrypy.tree.graft(app_logged, '/')
 
    # Set the configuration of the web server
    cherrypy.config.update({
        'engine1.autoreload.on': True,
        'log.screen': True,
        'server.socket_port': 10086,
        'server.socket_host': '127.0.0.1'
    })
 
    # Start the CherryPy WSGI web server
    cherrypy.engine.start()
    cherrypy.engine.block()
 
 
if __name__ == "__main__":
    # Init spark context and load libraries
    sc = init_spark_context()
    dataset_path = os.path.join('dataset','ml-latest-small')
    app = create_app(sc, dataset_path)
 
    # start web server
    run_server(app)

