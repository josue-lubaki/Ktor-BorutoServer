# Ktor-BorutoServer [![CircleCI](https://circleci.com/gh/josue-lubaki/Ktor-BorutoServer/tree/main.svg?style=svg&circle-token=f977735561fd7d6eadd35a153d67b8ceeccf57e9)](https://circleci.com/gh/josue-lubaki/Ktor-BorutoServer/tree/main)

---
![Imgur](https://i.imgur.com/FvR3xZV.png)


## Description
Android app for Boruto: Naruto Next Generations anime. It's a simple app that shows your favorite hero and his/her skills.

## Features
- List of heroes
- Hero details

---
### Go to Android app 📲[BorutoApp](https://github.com/josue-lubaki/BorutoApp) 👈

---

## Screenshots

<table border="1">
    <tr>
        <th align="center"> DARK MODE </th>
        <th align="center"> LIGHT MODE </th>
    </tr>
    <tr>
        <td align="center"> OnBoarding Page </td>   
        <td align="center"> OnBoarding Page </td>
    </tr>
    <tr>
        <td align="center"> <img src="https://i.imgur.com/DSqel2q.png" width=360 height=760 alt="onBoarding image"/></td>
        <td align="center"> <img src="https://i.imgur.com/kUr1TUE.png" width=360 height=760 alt="onBoarding image" /></td>
    </tr>
    <tr>
        <td> </td>
        <td> </td>
    </tr>
    <tr>
        <th align="center"> List of Heroes </th>
        <th align="center"> List of Heroes </th>
    </tr>
    <tr>
        <td> <img src="https://i.imgur.com/npp0rCT.jpg" width=360 height=760 alt="list heroes image"/></td>
        <td> <img src="https://i.imgur.com/e28LzTm.jpg" width=360 height=760 alt="list heroes image"/></td>
    </tr>
</table>

## Installation
1. Clone this repository
```bash
git clone https://github.com/josue-lubaki/Ktor-BorutoServer.git
```
2. Open the project in **intelliJ**
3. Run the project

## Routes
- Get all heroes
```shell
GET /boruto/heroes
```
---
- Get hero by name
```
GET /boruto/heroes/search?name={name}
```
- Example : GET hero by name
```shell
GET /boruto/heroes/search?name=sasuke
```

## Dependencies
- Koin-ktor
- Koin-logger
- Koin-test-host
- Kotlin-test
- logback-classic
- server-netty
- server-call-logging
- ktor-serialization


## License
[MIT License](https://github.com/josue-lubaki/Ktor-BorutoServer/blob/main/licence)

```
Copyright (c) 2023 Josue Lubaki

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
