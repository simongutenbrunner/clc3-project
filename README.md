# Project Description
The Calculator Web Application is a containerized project designed to illustrate an efficient development workflow utilizing GitHub Actions and the Gitflow extention for the development workflow. The primary goal is to demonstrate a well-organized development process with integrated automatic documentation generation and Continuous Integration (CI) capabilities. Following the Git flow principle, the repository is configured to automatically execute unit tests, providing immediate feedback to the developers. This ensures that the codebase remains robust and reliable throughout the development lifecycle.


The documentation can be found [here](https://simongutenbrunner.github.io/clc3-project/)

## Key features
1. Containerized Calculator Web Application
2. Git Flow Principle Integration
3. Automatic Documentation Generation
4. CI Feature Implementation
5. Automatically Publishing released Versions on DockerHub

## Technology Stack
**Java**:
- Primary programming language for developing the core functionalities of the calculator web application  

**Docker**:
- Containerization technology used to encapsulate the calculator web application and its dependencies.  

**Maven**:
- Build automation tool for managing the project's build lifecycle  

**GitHub**:
- Version control platform hosting the project repository
- Facilitates collaborative development, version tracking, and provides a centralized location for codebase hosting

**GitHub Actions**:
- Configured to automate tasks such as running unit tests, building the application, and deploying container images

**GitFlow Extension**:
- Extension for Git that implements the Git flow branching model.
- Enhances collaboration and streamlines the development process by providing a structured approach to feature branching, releases, and hotfixes

### Interaction of the Technologies
- **Development Workflow**: GitFlow extension is employed to manage feature branches, releases, and hotfixes within the Git repository. Maven is used for building the Java application, handling dependencies, and packaging artifacts.
- **Continuous Integration (CI)**: GitHub Actions is configured to automatically trigger CI workflows on each push to the repository. CI workflows include tasks such as running unit tests using Maven and providing immediate feedback to developers

# Git Flow

- ```main branch```: stable, production-ready state of project, should be deployable any time
- ```development branch```: features and fixes merged into this branch => development and integration
- ```feature branch```: branch off from develop and merge back into develop
- ```release branch```: prepare a new release, created from develop merged into both master and develop once the release is ready
- ```hotfix branch```: to address critical issues in production code. branched off from master and merged into master and develop

The defined Git Workflow:
- New features are developed in feature branches, branched off from ```develop```.
- Once a ```feature``` is complete, it is merged back into ```develop```.
- When a release is planned, a release branch is created from ```develop```.
- The ```release``` branch is used for final testing and preparing the ```release```.
- After testing, the ```release``` branch is merged into both ```main``` and ```develop```.
- If critical issues are found in production, a ```hotfix``` branch is created from ```main```.
- The ```hotfix``` is merged into both ```main``` and ```develop```.
- The cycle continues with ongoing development in the ```develop``` branch.

# Git Flow Example
![Workflow Example](/images/clc3_project_example.png)

## Initialize Git Flow

To start working with git flow you first need to initialize the git flow extension
```
git flow init
```


## Create a Feature branch

With Git-Flow it is possible to automatically create a feature brach out of a current `develop` branch by using the following Git-Flow command:
```
git flow feature start <feature_name>
```


After the feature branch has been created you can start implementing on it, using `git commit and git push` to keep the feature branch up to date during development.
In any case make sure to add the branch to origin using
```
git push --set-upstream origin feature/<feature_name>
```

When the feature was sucessfully implemented you can merge the feature branch back to develop:
```
git flow feature finish feature_branch
```

By using this command the ```feature``` branch is mergen in the ```develop``` branch and deleted afterwards. Now all that is left is to push the changes to the develop branch.
```
git push
```


## Create a Release Branch
When a `develop` branch includes enough features for a release, a new `release` branch is created from the ```develop``` branch.

```
git flow release start <release_version>
```
At this time no new features should be added to the branch, only bugfixes or release-oriented changes like bumping the version number are allowed.
Please also make sure to push the branch to origin using:
```
git push --set-upstream origin release/<release_version>
```

To finish the release process, the release branch needs to be merged into main. Then a new tag `v<release_version>` will be created. Then the tag will be merged into `develop` and the `release/<release version>` branch will be deleted.
All this can be achieved at once using:
```
git flow release finish <release_version>
```
Also, don't forget to push the new tag and the branches main and develop:
```
git push --tags
```
```
git push --all
```

## Create Hotfix Branch
When you need to do minor, but very urgent changes directly on the main branch you can do this via Hotfixes.
Firstly you need to start a new hotfix branch, branching directly off `main` using:
```
git flow hotfix start <hotfix_version>
```

On this branch you can commit and push your fixes. Please make also sure to then push the branch to origin using:
```
git push --set-upstream origin hotfix/<hotfix_version>
```

To finish the hotfix process, the hotfix branch needs to be merged into main. Then a new tag `v<hotfix_version>` will be created. Then the tag will be merged into `develop` and the `hotfix/<hotfix_version>` branch will be deleted.
All this can be achieved at once using:
```
git flow hotfix finish <hotfix_version>
```

Also, don't forget to push the new tag and the branches main and develop:
```
git push --tags
```
```
git push --all
```
# GitHub Actions
    name: Java CI
      

**Trigger Conditions**:  
```
on:
    push:
        branches: ["develop", "feature/**", "release", "hotfix"]
    pull_request:
        branches: [ "develop", "release"]
```
The workflow is triggered on two events:
- Push events on branches named "develop," "release," "feature/**," or "hotfix."
- Pull request events on branches "develop" or "release."  

**Jobs**: 
```
jobs:
    build_main_release:
```  
This workflow consists of a single job named "build_main_release."

**Operating System**
```
runs-on: ubuntu-latest
```
The job runs on the latest version of the Ubuntu operating system.

**Steps**:  
```
steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 17
    uses: actions/setup-java@v3
    with:
        java-version: '17'
        distribution: 'temurin'
        cache: maven
    - name: Run Maven Build
    run: mvn --no-transfer-progress clean install -B
```
- Checkout Action: The first step uses the actions/checkout action to clone the repository into the runner's workspace.
- Set up JDK 17: The second step sets up Java Development Kit (JDK) version 17 using the actions/setup-java action. It specifies the Java version, distribution (Temurin), and caches Maven dependencies for improved workflow execution time.
- Run Maven Build: The third step runs the Maven build using the mvn command. It performs a clean install of the project, skipping the transfer progress output (--no-transfer-progress), and running in batch mode (-B)

**Workflow Information:**
```
name: Release
```

The workflow is named "Release."

**Trigger Conditions:**
```
on:
    push:
        tags: ["v*"]
```
The workflow is triggered when a new tag is pushed to the repository. The trigger condition specifies tags starting with "v."

**Jobs:**
```
jobs:
  build_main_release:
```
This workflow consists of a single job named "build_main_release."

**Job Conditions:**
```
if: contains(github.ref, 'refs/tags/')
```

The job runs only if the GitHub reference contains "refs/tags/," indicating that it is a tag-based release.

**Operating System:**
```
runs-on: ubuntu-latest
```
The job runs on the latest version of the Ubuntu operating system.

**Steps:**  
Java Setup:  
The job contains several steps that perform various tasks:
```
- uses: actions/checkout@v3
- name: Set up JDK 17
  uses: actions/setup-java@v3
  with:
    java-version: '17'
    distribution: 'temurin'
    cache: maven
```
This sets up the Java Development Kit (JDK) version 17 for the build and caches Maven dependencies for improved workflow execution time.

Maven Build:
```
- name: Run Maven Build
  run: mvn --no-transfer-progress clean install -B
```
Executes the Maven build for the Java project.

Docker Setup:
```
- name: Set up Docker Buildx
  uses: docker/setup-buildx-action@v3
```
Sets up Docker Buildx for building multi-platform Docker images.

Docker Login:
```
- name: Login to DockerHub
  uses: docker/login-action@v3
  with:
    username: ${{ secrets.DOCKERHUB_USERNAME }}
    password: ${{ secrets.DOCKERHUB_TOKEN }}
```
Logs in to DockerHub using provided Docker Hub credentials.

Declare Variables:
```
- name: Declare variables
  id: vars
  shell: bash
  run: |
    echo "sha_short=$(git rev-parse --short HEAD)" >> $GITHUB_OUTPUT
```
Declares variables, including a short Git commit SHA, for later use.

Docker Image Build and Push:
```
- name: Publish Docker Image on Docker-Hub
  id: docker_build
  uses: docker/build-push-action@v5
  with:
    context: .
    push: true
    tags: simgut/calculator:${{ github.ref_name }}
```
Builds and pushes a Docker image based on the provided Dockerfile to Docker Hub.

Deploy JavaDoc:
```
- name: Deploy JavaDoc
  uses: MathieuSoysal/Javadoc-publisher.yml@v2.3.0
  with:
    GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
    javadoc-branch: javadoc
    java-version: 17
    target-folder: docs
```
Deploys JavaDoc using a third-party action (MathieuSoysal/Javadoc-publisher.yml@v2.3.0). It publishes Java documentation to the "docs" folder.


# Lessons Learned
* Setting up a proper workflow using Github actions can be a pain, especially the first time, but once done right is a really satisfying improvement for your quality-of-life.
* Don't reinvent the wheel
* The rabbit hole goes deeper (Jenkins, CD, Webhooks, ...)
* 

 

