asadmin create-jdbc-connection-pool --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype javax.sql.DataSource --steadypoolsize 2 --maxpoolsize 4 --poolresize 1 --idletimeout 300 --maxwait 60000 --ping true --property user=root:password=admin:servername=127.0.0.1:portnumber=3306:databasename=CasosAcad myjdbc_mariaconglassfish-pool
