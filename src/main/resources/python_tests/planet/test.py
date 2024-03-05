import os
import requests
import json
from urllib import request, parse

url = "http://localhost:8080/api/planet/"

reachablePlanets = {
    "galaxy": {
        "planets": {
            "1": {
                "id": 1,
                "portals": [
                    {"targetPlanetId": 2, "weight": 10},
                    {"targetPlanetId": 3, "weight": 5}
                ]
            },
            "2": {
                "id": 2,
                "portals": [{"targetPlanetId": 4, "weight": 1}]
            },
            "3": {
                "id": 3,
                "portals": [{"targetPlanetId": 4, "weight": 2}]
            },
            "4": {
                "id": 4,
                "portals": []
            }
        }
    },
    "startPlanetId": 1
}

stronglyConnected = {
    "galaxy": {
        "planets": {
            "1": {
                "id": 1,
                "portals": [
                    {"targetPlanetId": 2, "weight": 10},
                    {"targetPlanetId": 3, "weight": 5}
                ]
            },
            "2": {
                "id": 2,
                "portals": [{"targetPlanetId": 4, "weight": 1}]
            },
            "3": {
                "id": 3,
                "portals": [{"targetPlanetId": 4, "weight": 2}]
            },
            "4": {
                "id": 4,
                "portals": []
            }
        }
    }
}

shortestPath = {
    "galaxy": {
        "planets": {
            "1": {
                "id": 1,
                "portals": [
                    {"targetPlanetId": 2, "weight": 10},
                    {"targetPlanetId": 3, "weight": 5}
                ]
            },
            "2": {
                "id": 2,
                "portals": [{"targetPlanetId": 4, "weight": 1}]
            },
            "3": {
                "id": 3,
                "portals": [{"targetPlanetId": 4, "weight": 2}]
            },
            "4": {
                "id": 4,
                "portals": []
            }
        }
    },
    "source": 1,
    "target": 4
}

# ASSIGNMENT 1 TEST
response = requests.post(url + "1", json=reachablePlanets)

if response.status_code == 200:
    print("Assignment 1 - Reachable Planets:", response.json())
else:
    print("Error:", response.status_code, response.text)

# ASSIGNMENT 2 TEST
response = requests.post(url + "2", json=stronglyConnected)

if response.status_code == 200:
    print("Assignment 2 - Strongly Connected:", response.json())
else:
    print("Error:", response.status_code, response.text)

# ASSIGNMENT 2 TEST
response = requests.post(url + "3", json=shortestPath)

if response.status_code == 200:
    print("Assignment 3 - Shortest Path:", response.json())
else:
    print("Error:", response.status_code, response.text)


# ASSIGNMENT 4 TEST
response = requests.post(url + "4", json=stronglyConnected)

if response.status_code == 200:
    print("Assignment 4 - MostExpensiveShortestPath:", response.json())
else:
    print("Error:", response.status_code, response.text)