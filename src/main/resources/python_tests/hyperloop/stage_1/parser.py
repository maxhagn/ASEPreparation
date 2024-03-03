import os
import requests
import json
from urllib import request, parse

folder_path = './data'
url = 'http://localhost:8080/api/solution2'

def parse_file_to_json(file_path):
    with open(file_path, 'r') as file:
        lines = file.readlines()
        if len(lines) < 3:  # Basic validation to check if there are enough lines
            return None

        startPoint = list(map(int, lines[0].strip().split()))
        endPoint = list(map(int, lines[1].strip().split()))
        other_points = [list(map(int, line.strip().split())) for line in lines[3:]]

        assignment = {
            "startPoint": {"x": startPoint[0], "y": startPoint[1]},
            "endPoint": {"x": endPoint[0], "y": endPoint[1]},
            "points": [{"x": point[0], "y": point[1]} for point in other_points]
        }
        return assignment

def send_post_request(json_data):
    data = json.dumps(json_data).encode('utf-8')  # Convert JSON to bytes
    req = request.Request(url, data=data, headers={'Content-Type': 'application/json'})
    try:
        with request.urlopen(req) as response:
            response_body = response.read().decode('utf-8')
            return response.status, response_body
    except Exception as e:
        return None, str(e)

responses = []
for file_name in os.listdir(folder_path):
    file_path = os.path.join(folder_path, file_name)
    if os.path.isfile(file_path):
        json_data = parse_file_to_json(file_path)
        if json_data:
            print(json.dumps(json_data, indent=2))
            status_code, response_text = send_post_request(json_data)
            responses.append((file_name, status_code, response_text))
        else:
            print(f"Skipped file {file_name} due to format mismatch or insufficient data.")