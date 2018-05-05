from flask import Flask
from flask.ext.bootstrap import Bootstrap
from flask.ext.moment import Moment
#import sys
#sys.path.append("/Users/luo/Desktop/github/Spark_Movie_recsys/engine")
from engine.rec_engine import RecommendationEngine


bootstrap = Bootstrap()
moment = Moment()
#global recommendation_engine
def create_app(spark_context, dataset_path):
    from engine.rec_engine import RecommendationEngine
    global recommendation_engine
    recommendation_engine = RecommendationEngine(spark_context, dataset_path)

    app = Flask(__name__)
    app.config.from_object('config')
    #app.config['DEBUG'] = True

    bootstrap.init_app(app)
    moment.init_app(app)

    from .main import main as main_blueprint
    app.register_blueprint(main_blueprint)

    return app
