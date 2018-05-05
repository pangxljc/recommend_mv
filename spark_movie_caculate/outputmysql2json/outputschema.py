#-*-coding:utf-8-*-
import json,mysql.connector,datetime
import codecs

def Table2json_movie():
    conn = mysql.connector.connect(user='root', password='root', database='movie')
    cursor = conn.cursor("characterEncoding", "UTF-8")
    sql = "SELECT * FROM movie"
        #sql = "SELECT movieid ,moviename,showyear,nation, director, leaderactors,screanwriter,pm.apk_url AS du,pm.apkMd5 AS am,pm.minversionCode AS mc,pm.versionCode AS vc,pm.versionName AS vn, pm.signatureMd5 AS sm,pm.source AS se,pm.action AS ao FROM movie WHERE id = '1'"
    cursor.execute(sql)
    data = cursor.fetchall()
    print data
    cursor.close()
    conn.close()


    f = codecs.open('./movie.csv','a')

    for row in data:
        jsonData = []
        result = {}
        result['movieid'] =  "" if row[0]==None else row[0]
        result['moviename'] = "" if row[1]==None else row[1]
        try:
            result['showyear'] = datetime.datetime.strftime( datetime.datetime.now() if row[2].year<1900 else row[2],'%Y-%m-%d')
        except Exception,e:
            print e.message
        #datetime.datetime.now().strftime('%Y-%m-%d') if row[2] == None else str(row[2].year)+"-"+str(row[2].month)+"-"+str(row[2].day
        result['nation'] = "" if row[3]==None else row[3]
        result['director'] = "" if row[4]==None else row[4]
        result['leaderactors'] = "" if row[5]==None else row[5]
        result['screanwriter'] = "" if row[6]==None else row[6]
        result['picture'] = "" if row[7]==None else row[7]
        result['averating'] = "" if row[8]==None else row[8]
        result['numrating'] = "" if row[9]==None else row[9]
        result['description'] = "" if row[10]==None else row[10]
        result['typelist'] = "" if row[11]==None else row[11]
        result['backpost'] = "" if row[12]==None else row[12]
        jsonData.append(result)
        print jsonData
        jsondatar=json.dumps(jsonData)
        f.writelines(jsondatar[1:len(jsondatar)-1]+"\n")

    f.close()

def Table2json_category():
    conn = mysql.connector.connect(user='root', password='root', database='movie')
    cursor = conn.cursor()
    sql = "SELECT * FROM category"
        #sql = "SELECT movieid ,moviename,showyear,nation, director, leaderactors,screanwriter,pm.apk_url AS du,pm.apkMd5 AS am,pm.minversionCode AS mc,pm.versionCode AS vc,pm.versionName AS vn, pm.signatureMd5 AS sm,pm.source AS se,pm.action AS ao FROM movie WHERE id = '1'"
    cursor.execute(sql)
    data = cursor.fetchall()
    print data
    cursor.close()
    conn.close()


    f = codecs.open('./category.csv','a','utf-8')

    for row in data:
        jsonData = []
        #coding:utf-8
        result = {}
        result['categoryid'] =  "" if row[0]==None else row[0]
        category = row[1]
        categoryzh = category.encode("utf-8")
        result['category'] = ''
        result['category'] = categoryzh

        jsonData.append(result)
        print jsonData
        jsondatar=json.dumps(jsonData,encoding="UTF-8", ensure_ascii=False)
        f.writelines(jsondatar[1:len(jsondatar)-1]+"\n")

    f.close()

def Table2json_similartab():
    conn = mysql.connector.connect(user='root', password='root', database='movie')
    cursor = conn.cursor()
    sql = "SELECT * FROM similartab"
        #sql = "SELECT movieid ,moviename,showyear,nation, director, leaderactors,screanwriter,pm.apk_url AS du,pm.apkMd5 AS am,pm.minversionCode AS mc,pm.versionCode AS vc,pm.versionName AS vn, pm.signatureMd5 AS sm,pm.source AS se,pm.action AS ao FROM movie WHERE id = '1'"
    cursor.execute(sql)
    data = cursor.fetchall()
    print data
    cursor.close()
    conn.close()


    f = open('./similartab.csv','a')

    for row in data:
        jsonData = []
        result = {}
        result['itemid1'] =  "" if row[0]==None else row[0]
        result['itemid2'] = "" if row[1]==None else row[1]
        result['similar'] = "" if row[2] == None else row[1]

        jsonData.append(result)
        print jsonData
        jsondatar=json.dumps(jsonData)
        f.writelines(jsondatar[1:len(jsondatar)-1]+"\n")

    f.close()

def Table2json_moviecategory():
    conn = mysql.connector.connect(user='root', password='root', database='movie')
    cursor = conn.cursor()
    sql = "SELECT * FROM moviecategory"
        #sql = "SELECT movieid ,moviename,showyear,nation, director, leaderactors,screanwriter,pm.apk_url AS du,pm.apkMd5 AS am,pm.minversionCode AS mc,pm.versionCode AS vc,pm.versionName AS vn, pm.signatureMd5 AS sm,pm.source AS se,pm.action AS ao FROM movie WHERE id = '1'"
    cursor.execute(sql)
    data = cursor.fetchall()
    print data
    cursor.close()
    conn.close()


    f = open('./moviecategory.csv','a')

    for row in data:
        jsonData = []
        result = {}
        result['moviecatid'] =  "" if row[0]==None else row[0]
        result['movieid'] = "" if row[1]==None else row[1]
        result['categoryid'] = "" if row[2] == None else row[1]

        jsonData.append(result)
        print jsonData
        jsondatar=json.dumps(jsonData)
        f.writelines(jsondatar[1:len(jsondatar)-1]+"\n")

    f.close()

jsonstr = Table2json_category()
print jsonstr