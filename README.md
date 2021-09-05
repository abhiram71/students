# Students
To run RabbitMq in Docker : docker run -d --hostname my-rabbit --name some-rabbit -p 8080:15672 -p 5672:5672  rabbitmq:3-management                  


To run Elasticsearch :docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.14.1