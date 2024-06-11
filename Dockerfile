FROM postgres:latest

# Variáveis de ambiente
ENV POSTGRES_USER perguntou
ENV POSTGRES_PASSWORD quemteperguntou
ENV POSTGRES_DB perguntou

# Copie o arquivo de configuração personalizado (se necessário)
# COPY ./path/to/custom/pg_config.conf /etc/postgresql/postgresql.conf

EXPOSE 5432

# Opcional: adicione inicialização de scripts SQL
# COPY ./path/to/sql-scripts/ /docker-entrypoint-initdb.d/

# O comando de inicialização padrão para a imagem do PostgreSQL
CMD ["postgres"]
