
use banking;
db.dropDatabase();

use banking;
db.users.save({
  "userId" : "admin",
  "password" : "admin",
  "lastLoginDate" : "10/12/2009",
  "lastLoginTime" : "10:24 AM ET",
  "profileId" : "C3B789KK95-2F72-4253-90F2-8A971B54A63C",
  "tenantId" : "039E8ED1-313A-412B-9ED4-DEE675FF544A",
  "createdDate" : ISODate("2009-03-28T07:00:00Z"),
  "createdBy" : "anitha",
  "role" : {
    "primary" : "TENANT-ADMIN"
  }
}
);

db.profile.save({
  "profileId" : "C3B789KK95-2F72-4253-90F2-8A971B54A63C",
  "firstName" : "Anitha",
  "lastName" : "Sarath",
  "dateOfBirth" : ISODate("2012-10-10T07:00:00Z"),
  "sex" : "M",
  "tenantId" : "039E8ED1-313A-412B-9ED4-DEE675FF544A",
  "createdDate" : ISODate("2012-11-16T03:06:26.603Z"),
  "createdBy" : "Admin Admin",
  "phone" : "9445768910",
  "address" : "Anitha Software Solutions LTD, Kerala",
  "emailAddress" : "admin@anithass.com"
});

-----------------------------------------------------------------

db.tenants.save({
  "tenantId" : "C63A953AE20D404F8BB1F225CBC82CF0",
  "tenantName" : "HSBC Bank",
  "primaryContact" : "Tim Lee",
  "phoneNo" : "8776753452",
  "emailAddress" : "tim.lee@hsbc.com",
  "address" : "HSBC, Hongkong",
  "createdBy" : "anitha anitha",
  "createdDate" : ISODate("2012-11-15T22:48:25.239Z")
});

db.tenants.save({
  "tenantId" : "CCCEDA89EC74479AB5C20AF7ACCD789D",
  "tenantName" : "Citi Bank",
  "primaryContact" : "Thomas Mathew",
  "phoneNo" : "9008753452",
  "emailAddress" : "tmathew@citibank.com",
  "address" : "Citibank, Mumbai India",
  "createdBy" : "anitha anitha",
  "createdDate" : ISODate("2012-11-15T22:48:25.239Z")
})
