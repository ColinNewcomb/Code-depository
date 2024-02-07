import csv
#q1
def q1(csvfile):
    aList=[]
    with open(csvfile,'r') as fp:
        reader=csv.DictReader(fp)
        for row in reader:
            aList.append(dict(row))
    return aList
#q2
def q2(filename,records):
    with open(filename, mode='w', newline='',) as op:
        writer = csv.writer(op)
        header = list(records[0].keys())
        writer.writerow(header)
        for record in records:
                row = []
                for key in header:
                    row.append(record[key])
                writer.writerow(row)
        
#3
def q3(inputfile, outputfile, selectedfields):
    with open(inputfile, mode='r') as inf:
        with open(outputfile, mode='w', newline='') as op:
            reader = csv.DictReader(inf)
            writer = csv.DictWriter(op, fieldnames=selectedfields)
            writer.writeheader()
            for row in reader:
                selected_row = {}
                for field in selectedfields:
                    selected_row[field] = row[field]
                writer.writerow(selected_row)             
#q4
def q4(inputfile, outputfile, fieldname, fieldvalue):
    with open(inputfile, mode='r') as inf:
        reader = csv.DictReader(inf)
        with open(outputfile, mode='w', newline='') as op:
            writer = csv.DictWriter(op, fieldnames=reader.fieldnames)
            writer.writeheader()
            for row in reader:
                if row[fieldname] == fieldvalue:
                    writer.writerow(row)
                