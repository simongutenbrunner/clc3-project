# Project Description
The Calculator Web Application is a containerized project designed to illustrate an efficient development workflow utilizing GitHub Actions and the Gitflow extention for the development workflow. The primary goal is to demonstrate a well-organized development process with integrated automatic documentation generation and Continuous Integration (CI) capabilities. Following the Git flow principle, the repository is configured to automatically execute unit tests, providing immediate feedback to the developers. This ensures that the codebase remains robust and reliable throughout the development lifecycle.
The documentation can be found [here](https://simongutenbrunner.github.io/clc3-project/)

## Key features
1. Containerized Calculator Web Application
2. Git Flow Principle Integration
3. Automatic Documentation Generation
4. CI Feature Implementation

## Technology Stack

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

# GitHub Actions

# Git Flow Example
## Create Develop Branch

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


# Lessons Learned
* Setting up a proper workflow using Github actions can be a pain, especially the first time, but once done right is a really satisfying improvement for your quality-of-life.
* The rabbit hole goes deeper (Jenkins, CD, Webhooks, ...)
* 

 

