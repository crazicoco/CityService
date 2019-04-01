FROM mysql:5.7

ENV MYSQL_ROOT_PASSWORD 123456

COPY definition.sql /mysql/definition.sql
COPY insertion.sql /mysql/insertion.sql
COPY setup.sh /mysql/setup.sh

CMD ["sh", "/mysql/setup.sh"]
