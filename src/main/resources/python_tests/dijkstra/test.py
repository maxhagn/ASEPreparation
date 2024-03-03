import os
import requests
import json
from urllib import request, parse

url = "http://localhost:8080/api/dijkstra"

data = {
    "graph": {
        "adjacencyList": {
            "1": [{"target": 2, "weight": 10}, {"target": 3, "weight": 3}],
            "2": [{"target": 3, "weight": 1}, {"target": 4, "weight": 2}],
            "3": [{"target": 2, "weight": 4}, {"target": 4, "weight": 8}, {"target": 5, "weight": 2}],
            "4": [{"target": 5, "weight": 7}],
            "5": [{"target": 4, "weight": 9}]
        }
    },
    "source": 1,
    "target": 5
}


response = requests.post(url, json=data)

if response.status_code == 200:
    print("Shortest Path Distances:", response.json())
else:
    print("Error:", response.status_code, response.text)