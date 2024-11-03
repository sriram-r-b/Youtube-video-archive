# Youtube Video Archive

## Overview
This project is a tool for youtube content creators who need to track the script and Spring Boot application built with Maven.
It includes a simple service for adding content to a firestore db.
 This repo is a microservice implementation of two microservices combo. The other microservice being [Youtube Video Approval Dashboard](https://github.com/sriram-r-b/Youtube_video_approval_dashboard). Both microservices as a whole provide a complete solution for channels that need to maintain uniqueness within their content/analysis .

## Features
- Spring Boot framework
- FireStore integration
- Auth 0 secured
- Easy integration with youtube video approval dashboard
- Greeting service
- RESTful API

## Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- Firestore account
- Auth 0 account

## Getting Started

### Clone the Repository
```sh
git clone https://github.com/sriram-r-b/Youtube-video-archive.git
cd Youtube-video-archive
```

### Build the Project
```sh
mvn clean install
```

### Run the Application
```sh
mvn spring-boot:run
```

## Usage
The application exposes a REST endpoint to add content to the firestore db.
The endpoint will be secured with Auth 0.
Build the container and mount firebase credentials in secrets folder



## Contributing
Everyone is welcome to contribute to this project. Feel free to raise issues, create pull requests, or use it in your own projects.

1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Create a new Pull Request

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
