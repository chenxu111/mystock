mystock
mystock2
=======

Ant introduction, usage, 
write build.xml

an easy tool to build project
easy grammar, easy to learn
easy to use
cross platform
run faster on jvm
easily integrate with unit testing

how to configure
a. unzip ant
b. configure enviromental path
   ant_home = E:\apache-ant-1.8.1
   path = E:\apache-ant-1.8.1\bin

build.xml

how to design database

problem:
CREATE command denied to user 'root'@'localhost' 
solution:

dbcp
db connection pool:
a. initilize 10 connection in pool
b. use a connection from pool
c. return connection to pool

a. seperate code from configuration file
b. independent and reuseable connection pool unit
c. encapsulate connection pool

Dao(Data Access Object)

socket
service
dao, model,vo
database pool

org.freemoney.dao
AbstractDao
FundCompanyStockListDao
FundStockDetailDao
StockListDao

org.freemoney.dao
Fund
FundCompanyStockList
FundCompanyStockListKey
FundStockDetail
StockList

һ�����������࣬���Լ��ٱ������ѯ��������ѯ���ܣ�
���������Ķ��巽��
FundCompanyStockListKey.java
���������󣬾���ʵ�ʵ�Ͷ�ʲο���ֵ
���ǻ���ͬһ����˾������˾Ϊ��������̧�Σ�̧�������ǻ���ľ�ֵ
����Ŀǰ��������ҵ����


jdbc������
ÿ������һǧ����¼,ÿ����Ϊһ������,�ύ���ݿ⴦�������
���ʹ�÷�������

��ѯ���ݣ���װ����Ҫ�����ݸ�ʽ

ҵ��Ա��ϵͳ�ܹ���λ��
org.freemoney.service
AbstractServer.java
DataPumpService.java 
ExportService.java �ļ�������

org.freemoney.utils
Constant.java
FileUtil.java
HandleFile.java
PropsUtils.java
Utils.java
XLSExport.java

���������򿪷�
�򵥵�console����



