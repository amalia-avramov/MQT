Use Postman foe executing the commands.  
1. Get cluster Id

GET http://localhost:8082/v3/clusters

{
    "kind": "KafkaClusterList",
    "metadata": {
        "self": "http://rest-proxy:8082/v3/clusters",
        "next": null
    },
    "data": [
        {
            "kind": "KafkaCluster",
            "metadata": {
                "self": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A",
                "resource_name": "crn:///kafka=jMLFzvrSRp6tOpsfjSpU8A"
            },
            "cluster_id": "jMLFzvrSRp6tOpsfjSpU8A",
            "controller": {
                "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/brokers/1"
            },
            "acls": {
                "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/acls"
            },
            "brokers": {
                "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/brokers"
            },
            "broker_configs": {
                "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/broker-configs"
            },
            "consumer_groups": {
                "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/consumer-groups"
            },
            "topics": {
                "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics"
            },
            "partition_reassignments": {
                "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/-/partitions/-/reassignment"
            }
        }
    ]
}
 
2. Set cluster id
 $cluster="TZ7rbN7FQbCOYoBBiK-oDg"
 $cluster="KDT0WZN5TVi-edeqC1QwWg"
 quwMo_QkQrqYvutHUCfPbw
 
3. Create topic
Body --> raw  --> JSON
{ "topic_name" : "postman_topic" }

Headers
key -->  Content-Type value --> application/json

Post http://localhost:8082/v3/clusters/$cluster/topics

{
    "kind": "KafkaTopic",
    "metadata": {
        "self": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/postman_topic",
        "resource_name": "crn:///kafka=jMLFzvrSRp6tOpsfjSpU8A/topic=postman_topic"
    },
    "cluster_id": "jMLFzvrSRp6tOpsfjSpU8A",
    "topic_name": "postman_topic",
    "is_internal": false,
    "replication_factor": 0,
    "partitions_count": 0,
    "partitions": {
        "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/postman_topic/partitions"
    },
    "configs": {
        "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/postman_topic/configs"
    },
    "partition_reassignments": {
        "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/postman_topic/partitions/-/reassignment"
    }
}

4. List all topics: 
GET http://localhost:8082/v3/clusters/$cluster/topics

{
    "kind": "KafkaTopicList",
    "metadata": {
        "self": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics",
        "next": null
    },
    "data": [
        {
            "kind": "KafkaTopic",
            "metadata": {
                "self": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/_confluent-command",
                "resource_name": "crn:///kafka=jMLFzvrSRp6tOpsfjSpU8A/topic=_confluent-command"
            },
            "cluster_id": "jMLFzvrSRp6tOpsfjSpU8A",
            "topic_name": "_confluent-command",
            "is_internal": false,
            "replication_factor": 1,
            "partitions_count": 1,
            "partitions": {
                "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/_confluent-command/partitions"
            },
            "configs": {
                "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/_confluent-command/configs"
            },
            "partition_reassignments": {
                "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/_confluent-command/partitions/-/reassignment"
            }
        },
        {
            "kind": "KafkaTopic",
        ...
        },
        ...
        ...
    ]
}

 
5. Describe topic

GET  http://localhost:8082/v3/clusters/$cluster/topics/postman_topic

{
    "kind": "KafkaTopic",
    "metadata": {
        "self": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/postman_topic",
        "resource_name": "crn:///kafka=jMLFzvrSRp6tOpsfjSpU8A/topic=postman_topic"
    },
    "cluster_id": "jMLFzvrSRp6tOpsfjSpU8A",
    "topic_name": "postman_topic",
    "is_internal": false,
    "replication_factor": 1,
    "partitions_count": 1,
    "partitions": {
        "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/postman_topic/partitions"
    },
    "configs": {
        "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/postman_topic/configs"
    },
    "partition_reassignments": {
        "related": "http://rest-proxy:8082/v3/clusters/jMLFzvrSRp6tOpsfjSpU8A/topics/postman_topic/partitions/-/reassignment"
    }
}

6. Send data 
Body --> raw  --> JSON
{ "key": { "type": "JSON", "data": "key1" },
  "value": { "type": "JSON", "data": "value1 Buna" }
}

Headers
key -->  Content-Type value --> application/json
POST http://localhost:8082/v3/clusters/$cluster/topics/curl_topic/records

curl.exe -X POST -H "Content-Type: application/json" --data '{ \"key\": { \"type\": \"JSON\", \"data\": \"key1\" }, \"value\": { \"type\": \"JSON\", \"data\": \"value1 Buna\" } }' "http://localhost:8082/v3/clusters/$cluster/topics/curl_topic/records"

7. Create a consumer group

Body --> raw  --> JSON
{"name": "FirstConsumer", "format": "json", "auto.offset.reset": "earliest"}   

Headers
key -->  Content-Type value --> application/vnd.kafka.v2+json

POST http://localhost:8082/consumers/HappyGroup


curl.exe -X POST -H "Content-Type: application/vnd.kafka.v2+json"  --data '{\"name\": \"FirstConsumer\", \"format\": \"json\", \"auto.offset.reset\": \"earliest\"}'   http://localhost:8082/consumers/HappyGroup

{
    "instance_id": "FirstConsumer",
    "base_uri": "http://rest-proxy:8082/consumers/HappyGroup/instances/FirstConsumer"
}

8. Create subscription 
Body --> raw  --> JSON 
{"topics": ["postman_topic"]}

Headers
key -->  Content-Type value --> application/vnd.kafka.v2+json

POST http://localhost:8082/consumers/HappyGroup/instances/FirstConsumer/subscription

-- aici se poate adauga si o lista de topic-uri : {\"topics\": [\"topicFromPostman\", \"topic2\"]}
curl.exe -X POST -H "Content-Type: application/vnd.kafka.v2+json"  --data '{\"topics\": [\"topicFromPostman\"]}' http://localhost:8082/consumers/HappyGroup2/instances/FirstConsumer/subscription

9. Get messages
Headers
key -->  Content-Type value --> application/vnd.kafka.v2+json
key -->  Accept				--> application/vnd.kafka.json.v2+json
GET http://localhost:8082/consumers/HappyGroup/instances/FirstConsumer/records 

curl.exe -X GET  -H "Content-Type: application/vnd.kafka.json.v2+json" -H "Accept: application/vnd.kafka.json.v2+json"  "http://localhost:8082/consumers/HappyGroup/instances/FirstConsumer/records" 
curl.exe -X GET  -H "Content-Type: application/vnd.kafka.json.v2+json" -H "Accept: application/vnd.kafka.json.v2+json"  "http://localhost:8082/consumers/GrupConsumatori/instances/PrimulConsumer/records" 

10. Delete consumer group

curl.exe -X DELETE  -H "Content-Type: application/vnd.kafka.v2+json"  http://localhost:8082/consumers/GrupConsumatori/instances/PrimulConsumer

