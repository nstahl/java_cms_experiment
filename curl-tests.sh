# Create Index
curl -XPUT 'http://1a899325e2c31027087ee0973b7433c0.us-east-1.aws.found.io:9200/twitter/'

# Add document
curl -XPUT 'http://1a899325e2c31027087ee0973b7433c0.us-east-1.aws.found.io:9200/twitter/tweet/1' -d '{
    "tweet" : {
        "user" : "kimchy",
        "post_date" : "2009-11-15T14:12:12",
        "message" : "trying out Elastic Search"
    }
}'

# Get document by id
curl -XGET 'http://1a899325e2c31027087ee0973b7433c0.us-east-1.aws.found.io:9200/twitter/tweet/1'

# Search document
curl -XGET 'http://1a899325e2c31027087ee0973b7433c0.us-east-1.aws.found.io:9200/twitter/tweet/_search?q=user:kimchy'
