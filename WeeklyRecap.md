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

#### 12/3/23

 * integrated cognito authentication and user database and its working (log in existing user, new user sign up, etc.)
 * had some issues with log4j again so spent sometime with that for a bit at the start but got it working again
 * note - woke up feeling really sick, thankfully got the above all working, now going to rest a bit 

#### 12/4/23

* reviewed projects, learning tracker, notes from previous week or so
* met with Paula to discuss indie project and planning
  * add teams table for users to track favorite teams
  * user -> user_team <- team (won't need entity for join table) (fetch type eager, not lazy)
  * [https://mkyong.com/hibernate/hibernate-many-to-many-relationship-example-annotation/]()
* review above resource, mocked up some db designs, will start implementing tomorrow
  * also, reminder to add User to session
 
#### 12/5/23 (1:?? - 6:15 pm)

* focus today was on hibernate and creating and implenenting the user-team join table. first had to create the teams table, and generated a sqldump for that.
* revisted a lot of Hibernate material along the way to refamiliarize myself with it. it's pretty cool!
* at the point where i can add users favorite teams, unit testing for that went well but removing favorite teams ended up removing the team from the team table too.. so I'll have to revisit that one. Made it so the view all users jsp also shows each users favorite teams in an unordered list
* forgot to use a different branch and worked on main...whoops. caught myself maybe halfway in, but was right in the middle of something and forgot again. Will remember to do this again next time. Would like to clean things up first though - make sure main is in a good spot (i think it is but i'm tired so i will double check tomorrow) and then move to my dev branch.
* thoughts on what to do next:
  * still need to add User to session!
  * create user homepage (vs general homepage)
  * add way for user to add teams to favorites
  * and then....add teams page, and "team" page
  * ....to be continued

#### 12/8/23

Things are going well with the indie project. I'm extra happy because the past couple days I wasn't able to do much and was worried about picking back up. Having next steps noted above in the entry from 12/5 was definitely helpful :) Spent a couple hours on various things for the course but mainly continued to work on indie project.
* User is now added to session upon login.
* Once a user is logged in, additional info appears on homepage (right now just that they're logged in)
* Set up teams page and controller and this is successfully populating from db and linked to homepage
* These changes are deployed to aws.
* I was occasionally running into an issue with auth where token was not able to be used before (now) ..seems like it maybe has something to do with the time on the server or in the db or something being wrong/needing set? only happens sometimes, and seems to just be when deployed locally via tomcat.

Next steps:
* user homepage -or- update homepage to be user specific once logged in
* "team" page
* add/remove favorite team funcitonality for auth'd user
* ERROR PAGE! routing to it in auth controller
* ???


#### 12/9/23

Pretty solid day of project work. Wish I had more time to get things cleaned up more. Should have done more along the way! Hindsight or whatever. Anyway, spent a few hours and got the following done (still need cleaned up refactored etc)
* teams page - show all teams
* team (single) page - show details about selected team
* update home page for pre-login vs once user is logged in
  * once user logged in, sees their user info and favorite teams. link to edit favorite teams
* add and remove teams from user favorite team list.
* deployed updated webapp to aws
This is the outcome of the work today, added a number of classes, jsps, tests, etc. to get everything mentioned linked up and functioning smoothly.

NEXT STEPS
- Looks like that leaves the error page routing. I will do that next.
- Refactoring and clean up before things get out of hand
- javadocs
- more unit tests? coverage is good for the daos utilized, but should probably get some more in there.
- ???
