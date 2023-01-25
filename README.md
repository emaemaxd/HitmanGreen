# Exercise MongoDB.09 – Microproject :smile:

> Fragen: Gibt es vererbung in MongoDB -> nein gibt es nicht, aber man kann sie im Model abbilden, ist aber DB egal 

> ERD kann man jetzt so lassen

## Introduction

In the past assignments we have trained how to:

- Set up a MongoDB in a [ local ] Docker container
- Configure a MongoDB driver to connect to the database instance
- Prepare entities, repositories and queries as well as insert/update/delete operations
- Provide a REST webservice with dependency injection
- Create a simple client with which to consume the services and provide (basic) functionality for the user

You will work in four groups. Each group will get *assigned a topic*. In this context you’ll create a small application which uses a MongoDB instance as data storage backend.
You are allowed to use any platform/driver you like.

## Project Size

While you are of course free to create a bigger project with more functionality these are the minimum requirements you have to fulfill:

### User Stories

Implement at least *three* user stories

- For example such user stories could be: browse products, shopping cart, order list, multiple users, live ticker, comments, picture upload, ...
- This depends highly on your topic, but think of it as ’one feature implemented from client through service till database’.

> 1. Als User möchte ich einen Kauf tätigen.
> 2. Als User möchte ich einen Proof of Concept, dass mein Job erledigt wurde
> 3. Als User möchte ich Hitman werden
> 4. Als User möchte ich die Bewertungen von Hitmen sehen können
> 5. Als User möchte ich die Hitmen filtern können
> 6. Als Hitman möchte ich einen Kauf immer ablehnen können

### Endpoints

The endpoints (controllers) support the user stories

- You’ll usually need at least one per distinct (collection) entity
- Add methods as required
- Do *not* use the repositories directly but utilize *services*!
  - At least *one* service method has to be *non trivial* (not just relaying to the repository)

### Entities

Use at least five different entities

- You have to use at least once embedded documents, but at the same time have at least two distinct collections
- You will need at least one ’pseudo foreign key’ relation
- You have to create at least *one* index – this can be a unique index if used meaningful

### Repositories

All distinct collections have to have their own repository

- Create at least one each of the following queries/operations in the project, those do *not* need to be all in one repository:
  - Insert
  - Update
  - Delete
  - Filtered Query
  - Aggregation Query
  - Join (lookup) Query

### Client

The client should be basic but functional

- You may choose any frontend platform you like (even server generated)
- You do not have to invest highly into design!
- The client is to be technically sound enough that it can be treated as prototype for a ’proper’ client that would be created later on
- The goal of the client is to showcase the functionality/user stories

## Project Quality

Create a GitHub repository (private and add me as member) and work with a proper git work- flow (regular commits, meaningful commit messages, different branches, pull requests, ...).
Attempt proper decoupling of components via dependency injection as well as clean and solid coding.
Unit tests can be created for all non trivial service methods. In addition create integration tests for all non trivial (e.g. not a simple insert) database operations/queries.
The application has to be functional of course.

## Presentation

After completing the microproject you will present (about 10 minutes) your solution in class. Focus on the following aspects:

- General topic
- User stories
- Tricky implementation aspects (+ your solution)
- Showcase of the functionality

Prepare your application in such a way (e.g. server available in the network) that your class- mates are able to try out the application themselves after your presentation!
