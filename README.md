# Git Flow Example
## Create Develop Branch
Create a ```develop``` branch and initialize the supporting branch prefixes.

```
git flow init
```
This allows you to initialize the following supporting branches:  

- ```feature```
- ```release```
- ```hotfix```
- ```support```

What are the listed branches used for and how do they interact?

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

## Create a Feature branch

With Git-Flow it is possible to automatically create a feature brach out of a current ```develop``` branch by using the following Git-Flow command

```
git flow feature start feature_branch
```

After the feature implementation is finished the ```feature``` again needs to be merged in the ```develop``` branch.

```
git flow feature finish feature_branch
```

By using this command the ```feature``` branch is mergen in the ```develop``` branch and deleted afterwards.


## Create a Release Branch
When a ```develop``` branch includes enough features for a release, a ```release``` branch is forked from the ```develop``` branch. At this time no new features should be added to the branch, only bugfixes or release-oriented changes are allowed. 

```
git flow release start 0.1.0
```

If release is ready the ```release``` branch is merged in the ```main``` branch and tagged with a version number. The ```release``` branch should also be merged in the ```develop``` branch. 

```
git flow release finish '0.1.0'
```

## Create Hotfix Branch
A ```hotfix``` branch is the only branch that should be forked from the ```main``` branch. 

```
git flow hotfix start hotfix_branch
```

After the hofix is finished, the ```hotfix``` branch needs to be merged both in ```main``` and ```develop```, and the ```main``` branch needs to be tagged with a new version number.

```
git flow hotfix finish hotfix_branch
```


 

