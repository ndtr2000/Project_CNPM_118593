create database if not exists `ProjectSoftWareDB`;
use `ProjectSoftWareDB`;
create table `Person`(
`PersonId` int(11),
`Name` varchar(45) default null,
`BirthOfDate` date default null,
`Adress` varchar(50) default null,
`Job` varchar(45) default null,
 PRIMARY KEY(PersonId)
);
create table `Student`(
`StudentId` int(11),
`PersonId` int(11) default null,
`University` varchar(45) default null,
FOREIGN KEY (PersonId) REFERENCES Person(PersonId),
 PRIMARY KEY(StudentId)
);
create table `TimeLiving`(
`TimeLivingId` int(11),
`Time` varchar(45) default null,
 PRIMARY KEY(TimeLivingId)
);
create table `Family`(
`FamilyId` int(11),
`FamilyName` varchar(45) default null,
`Adress` varchar(50) default null,
`AmountOfMember` int(5) default null,
 PRIMARY KEY(FamilyId)
);
create table `PositionInFamily`(
`PositionInFamilyId` int(11),
`PositionName` varchar(45) default null,
 PRIMARY KEY(PositionInFamilyId)
);
create table `MatchFamilyWithPerson`(
`FamilyId` int(11) default null,
`PersonId` int(11) default null,
`TimeLivingId` int(11) default null,
`IsLivingNow` boolean default null,
`PositionInFamilyId` int(11) default null,
FOREIGN KEY (PersonId) REFERENCES Person(PersonId),
FOREIGN KEY (FamilyId) REFERENCES Family(FamilyId),
FOREIGN KEY (TimeLivingId) REFERENCES TimeLiving(TimeLivingId),
FOREIGN KEY (PositionInFamilyId) REFERENCES PositionInFamily(PositionInFamilyId)
);
create table `ManageJobVillage`(
`JobId` int(11),
`NameJob` varchar(50) default null,
 PRIMARY KEY(JobId)
);
create table `Manager`(
`PersonId` int(11) default null,
`JobId` int(11) default null,
FOREIGN KEY (PersonId) REFERENCES Person(PersonId),
FOREIGN KEY (JobId) REFERENCES ManageJobVillage(JobId)
);