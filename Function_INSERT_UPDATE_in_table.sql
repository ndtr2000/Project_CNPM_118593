/*
Những chỗ /*idPerson*/.... là để nạp thông tin vào để lấy thông tin từ bàn phím ....
*/
use cnpm20201;
#Lay chu nha
SELECT family.idFamily,lastName,firstName from family,person 
	WHERE person.idPerson=family.idFamilyMaster;
#Them nguoi

INSERT INTO person 
VALUE(
#/*idPerson*/,
#/*idFamily*/,
#/*LastName*/,
#/*firstName*/,
#/*relationship*/,
#/*birth*/,
#/*adress*/,
#/*gender*/,
#/*email*/,
#/*job*/,
#/*identityID*/,
#/*education*/
);

#UPDATE thông tin nguoi
UPDATE person 
SET 
idFamily=/*idFamily*/,
LastName=/*LastName*/,
firstName=/*firstName*/,
relationship=/*relationship*/,
birth=/*birth*/,
adress=/*adress*/,
gender=/*gender*/,
email=/*email*/,
job=/*job*/,
education=/*education*/
WHERE idPerson=/*idPerson*/;


#Them hoc sinh
INSERT INTO student VALUE("/*idStudent*/,/*idPerson*/,/*hometown*/,/*university*/,/*startLiving*/");

#UPDATE thông tin học sinh
UPDATE student
SET
idStudent=/*idStudent*/,
idPerson=/*idPerson*/,
hometown=/*hometown*/,
university=/*university*/,
startLiving=/*startLiving*/
WHERE idStudent=/*idStudent*/;

#Them nguoi thue
INSERT INTO renter VALUE("/*idrenter*/,/*idPerson*/,/*hometown*/,/*startLiving*/");

#UPDATE thông tin người thuê
UPDATE renter
SET
idPerson=/*idPerson*/,
hometown=/*hometown*/,
startLiving=/*startLiving*/
WHERE idrenter=/*idrenter*/;

#Them gia dinh
INSERT INTO renter VALUE("/*idFamily*/,/*idFamilyMaster*/");

#UPDATE thông tin gia đình
UPDATE renter
SET
idFamilyMaster=/*idFamilyMaster*/,
WHERE idFamily=/*idFamily*/;

#Them meeting
INSERT INTO renter VALUE("/*idMeeting*/,/*date*/,/*place*/,/*topic*/");

#UPDATE thông tin meeting
UPDATE renter
SET
date=/*date*/,
place=/*place*/,
topic=/*topic*/
WHERE idMeeting=/*idMeeting*/;

