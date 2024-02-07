from src_milestone1 import computeFrequency
from src_milestone1 import filterByKey
from src_milestone2 import convertToLists
from src_milestone2 import writeRecords
from src_milestone2 import loadRecords
from src_milestone2 import convertToDictionaries
import urllib.request
import matplotlib.pyplot as plt
import os
import numpy as np
import json
import csv

def cacheAndLoadData(filename):
    if not os.path.isfile(filename):
        url='https://data.buffalony.gov/resource/6xz2-syui.json'
        response=urllib.request.urlopen(url)
        data=json.loads(response.read().decode())
        keys=['title','category','type','medium','frame','photo_url_link','artist',
        'site','street_address','city','zip_code','state','latitude','longitude']
        lists=convertToLists(keys,data)
        with open(filename,"w",newline='') as fp:
            writer= csv.writer(fp)
            writer.writerow(keys)
        writeRecords(filename,lists)
        datalist = loadRecords(filename)
        dictionary = convertToDictionaries(keys, datalist)
        return dictionary
    else:
        keys=['title','category','type','medium','frame','photo_url_link','artist',
        'site','street_address','city','zip_code','state','latitude','longitude']
        datalist = loadRecords(filename)
        dictionary=convertToDictionaries(keys, datalist)
        return dictionary 

def cleanData(data):
    for dictionaries in data:
        for key in dictionaries:
            if key == "category":
                if  dictionaries[key] == "PAINTINGS":
                    dictionaries[key]="PAINTING"
                elif dictionaries[key] == "DECORATIVE OBJECTS":
                    dictionaries[key]="DECORATIVE OBJECT"
                elif dictionaries[key] in ["GRAPHIC","GRAPHICS","GRAPHICS ART","GRAPHICS ARTS"]:
                    dictionaries[key]="GRAPHIC ARTS"
    return None

def plotPieForKey(key,data):
    labels=[]
    sizes=[]
    dataset=computeFrequency(key,data)
    for key in dataset.keys():
        labels.append(key)
        sizes.append(int(dataset[key]))
    fig, ax = plt.subplots()
    ax.pie(sizes,labels=labels)
    plt.show()
    return None

def plotBarForKey(key,data):
    labels=[]
    sizes=[]
    dataset=computeFrequency(key,data)
    for key in dataset.keys():
        labels.append(key)
        sizes.append(int(dataset[key]))
    fig, ax = plt.subplots()
    y_pos=np.arange(len(labels))
    ax.barh(y_pos,sizes)
    ax.set_yticks(y_pos, labels=labels)
    ax.invert_yaxis()
    plt.show()
    return None

def plotFilteredBarForKey(key,fkey,fval,data):
    labels=[]
    sizes=[]
    dataset=filterByKey(fkey,fval,data)
    compute=computeFrequency(key,dataset)
    for key in compute.keys():
        labels.append(key)
        sizes.append(int(compute[key]))
    fig, ax = plt.subplots()
    y_pos=np.arange(len(labels))
    ax.barh(y_pos,sizes)
    ax.set_yticks(y_pos, labels=labels)
    ax.invert_yaxis()
    plt.show()
    return None

