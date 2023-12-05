# Weekly Journal

### ...

### Week 4

9/18/23 - 9/24/23 (12-13 hours)

* Project research and brainstorming, finally deciding on something
* Week 4 readings, videos, activities, and exercise
* Project repo creation and set up general structure, config files, etc.
* Create user database for project
  * Create corresponding pojo, dao, test classes


### Week 5

9/25/23  (2.5 hours)

* Review project instructions, checkpoints, etc.
* Add to class individual project list
* Project documents set up
* Problem Statement, User Stories, Time tracker
* Create Project Plan
* Work on screen designs

9/26/23 (1 hour)

* screen design - rough draft (figuring out figma again!)
* submit for checkpoint 1 ? 
* week 5 overview and start readings

9/27/23 (3.5 hours)
* watched week 5 videos, followed along with demo
* resolved issue with test_sample db user table
* chose professional development project topic + sign up
* watched learning tracker video and reviewed learning tracker

### ** Several weeks are on paper **
Will add if I have the time, and remember! Trying to better the past week or two. Wrote them on my phone. Should probably just update them on here right away instead of having to transfer...

### Week 13

...

11/23/23 (0.5 hrs)
* week 13 videos
* start first reading

11/24/23
* refactor group project google books api; worked with log4j and got reoriented with that and its settings; junit and unit test; merged branch into main
* finished readings and started working on week 13 exercise but ran into issues. posted question in slack help channel
* install stuff on new laptop, trying to get set up for course.. my current laptop is shutting down randomly now. spent some time trying to get this all set up

11/25/23
* went right to work on week 13 after finding out need to install tomEE. struggled a lot trying to get this working and completely lost track of time. tried figuring out debugging tomee and stuff but started going in circles. added follow up question in slack. wore myself out so needed to take a break.
* prepped for group meeting - this got moved to tomorrow
* got mySQL working on new computer. should be last thing needed besides maybe some setup/config
* looked at what needs to be done for check point 3 indie proj

### Week 14

11/26/23
* troubleshooting week 13

11/27/23
* week 13 troubleshooting
* group meeting, ended up a bit short. going to help look at testing routes
* look at branching exercise
* updated unit tests for multiple authors and merged with main for group proj

11/28/23
* review week 13 updates
* review checkpoint 3 indieproj
* week 13 exercise work, but also worked busy it guide shift

11/29/23
* spent about an hour wrapping up week 13 exercise, rewatched lecture and exercise video which pulled things together nicely
* think about plan for final project
* reviewed project, tried to set up mysql db on new computer and fought with mysqldump on old computer..
* looked at apis for indie proj and tested using Postman

11/30/23
* review learning tracker and indie proj requirements; review feedback in issues from past exercises, checkpoints, etc.
* got dbs setup on new computer and implemented logger in indie proj/removed a couple printlns and printStackTrace()s
* updated weekly recap/time tracker.
* reviewed db structure and previous exercises, projects, course work
* trying to plan/prioritize remainder of semester...
* start set up dao for free nba api and working on unit tests...wondering if i should use mockaroo or something else
 
12/1/23
* deployed indie project to aws and set up db config, made dev branch to work on new features
* more planning/considering how to prioritize tasks the remainder of the semester
* next steps: set up cognito with indie proj
  
12/2/23 
* spent the day working through getting cognito set up and integrated with my web app and db. had to redo everything after deploying the integrated app to beanstalk because it was erroring when trying to switch from nginx to apache so i just made a new environment and everything. i did this after a long day and fumbled a bit the first try (i think i just forgot to open up port 3306 for the db and my local machine...) but everything worked out on the third go around! web app is deployed and i have data from db displaying to a show users page. and auth/login with cognito seems to be working on the deployed version too!
* the main thing left to do with cognito is integrate it with the my user db, but i have a plan and think i can get things sorted out
* utilized (most of the time) an auth branch while implementing login functionality. was good about using it and merging with main earlier in the day. i made a few changes on main later on but they were pretty minor overall i think 

 12/3/23
 * integrated cognito authentication and user database and its working (log in existing user, new user sign up, etc.)
 * had some issues with log4j again so spent sometime with that for a bit at the start but got it working again
 * note - woke up feeling really sick, thankfully got the above all working, now going to rest a bit 

12/4/23
* reviewed projects, learning tracker, notes from previous week or so
* met with Paula to discuss indie project and planning
  * add teams table for users to track favorite teams
  * user -> user_team <- team (won't need entity for join table) (fetch type eager, not lazy)
  * [https://mkyong.com/hibernate/hibernate-many-to-many-relationship-example-annotation/]()
* review above resource, mocked up some db designs, will start implementing tomorrow
  * also, reminder to add User to session