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

一定的数据冗余，可以减少表关联查询，提升查询性能；
符合主键的定义方法
FundCompanyStockListKey.java
基金抱团现象，具有实际的投资参考价值
明星基金，同一基金公司下属公司为其他基金抬轿，抬升该明星基金的净值
比如目前的银行行业基金


jdbc批处理
每次增加一千条记录,每批成为一个事务,提交数据库处理的性能
如何使用符合主键

查询数据，封装成需要的数据格式

业务员在系统架构的位置
org.freemoney.service
AbstractServer.java
DataPumpService.java 
ExportService.java 文件导出类

org.freemoney.utils
Constant.java
FileUtil.java
HandleFile.java
PropsUtils.java
Utils.java
XLSExport.java

管理主程序开发
简单的console界面



