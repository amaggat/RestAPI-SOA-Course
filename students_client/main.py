import requests
import json


DATA = '''
[
    {
        "name": "Trần Trung Thành",
        "dob": "2000-09-18",
        "student-id": 18021174,
        "gender": "Male",
        "email": "18021174@vnu.edu.vn",
        "contacts": [
            {
                "name": "Trần Văn ABC",
                "address": "Đông Anh, Hà Nội"
            },
            {
                "name": "Nguyễn Thị XYZ",
                "address": "Đông Anh, Hà Nội"
            }
        ]
    },
    {
        "name": "Nguyen Tien Trong",
        "dob": "2000-09-18",
        "student-id": 18021174,
        "gender": "Male",
        "email": "18021174@vnu.edu.vn",
        "contacts": [
            {
                "name": "Trần Văn ABC",
                "address": "Đông Anh, Hà Nội"
            },
            {
                "name": "Nguyễn Thị XYZ",
                "address": "Đông Anh, Hà Nội"
            }
        ]
    }
]
'''


def get(id):
    #global DATA

    r = requests.get("http://127.0.0.1:8080/api/students/" + id)

    return r.json()


def get_all():
    #global DATA
    r = requests.get("http://127.0.0.1:8080/api/students/")

    return r.json()


while True:
    print('-------------------------------------')
    print('Select options:')
    print('[1] Get all users')
    print('[2] Get user by id')
    print('-------------------------------------')

    option = input(">>> ")
    if option == '1':
        print(get_all())
    elif option == '2':
        value = input("Input user id: ")
        print(get(value))
