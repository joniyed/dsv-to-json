# DSV to JSON

- This is a simple Maven project that converts DSV (Delimiter-separated values) files into JSONL (JSON line) format.

## Packaging

Use maven to install create jar file.

```bash
mvn package
```

## Run

Use java -jar command to run the packaged jar file

```bash
java -jar target/dsv-to-json-1.0.0.jar
```

## After Run Jar (Usage)

###### If the user does not turn it off, the whole system will run forever.

- First Input

```output demo
----------------------------------
Please Enter the file path: 
----------------------------------

input/DSV input 1.txt

----------------------------------
Do you want to change delimiter (default: ,(comma)) ??
1.yes
2.no
Please Enter 1 or 2
----------------------------------

2

----------------------------------
Please Enter Output File Name: 
----------------------------------

dsv 1  

Started. please wait.....

----------------------------------
Successfully Done..
----------------------------------

```

- Second Input

```
----------------------------------
Do you want to do more work??
 1.yes
 2.no
Please Enter 1 or 2
----------------------------------

1

----------------------------------
Please Enter the file path: 
----------------------------------

input/DSV input 2.txt

----------------------------------
Do you want to change delimiter (default: ,(comma)) ??
1.yes
2.no
Please Enter 1 or 2
----------------------------------

1

----------------------------------
Please Enter Your Delimiter: 
----------------------------------

|

----------------------------------
Please Enter Output File Name: 
----------------------------------

dsv 2

Started. please wait.....

----------------------------------
Successfully Done..
----------------------------------

```

- Third Input

```
----------------------------------
Do you want to do more work??
 1.yes
 2.no
Please Enter 1 or 2
----------------------------------

1

----------------------------------
Please Enter the file path: 
----------------------------------

input/sample-data.csv

----------------------------------
Do you want to change delimiter (default: ,(comma)) ??
1.yes
2.no
Please Enter 1 or 2
----------------------------------

2

----------------------------------
Please Enter Output File Name: 
----------------------------------

sample-data

Started. please wait.....
5000 json write into file.
10000 json write into file.

----------------------------------
Successfully Done..
----------------------------------

```

- Fourth Input

```
----------------------------------
Do you want to do more work??
 1.yes
 2.no
Please Enter 1 or 2
----------------------------------

1

----------------------------------
Please Enter the file path: 
----------------------------------

input/Student List.txt

----------------------------------
Do you want to change delimiter (default: ,(comma)) ??
1.yes
2.no
Please Enter 1 or 2
----------------------------------

1

----------------------------------
Please Enter Your Delimiter: 
----------------------------------

;

----------------------------------
Please Enter Output File Name: 
----------------------------------

student list

Started. please wait.....

----------------------------------
Successfully Done..
----------------------------------


```

- Stop Manually

```

----------------------------------
Do you want to do more work??
 1.yes
 2.no
Please Enter 1 or 2
----------------------------------

2

```

## Contributing

This is the whole thing, which I understood from the requirements. I tried to complete the whole requirement which is
attached to the document. I think you will like my effort.

# Date Format

I am trying to convert multiple date format into yyyy-MM-dd.

- Sample Date Format:

        String dateFormat1 = "dd-MM-yyyy";
        String _dateFormat1 = "MM-dd-yyyy";
        String dateFormat2 = "yyyy-MM-dd";
        String _dateFormat2 = "yyyy-dd-MM";
        String dateFormat3 = "dd/MM/yyyy";
        String _dateFormat3 = "MM/dd/yyyy";
        String dateFormat4 = "yyyy/MM/dd";
        String _dateFormat4 = "yyyy/dd/MM";
