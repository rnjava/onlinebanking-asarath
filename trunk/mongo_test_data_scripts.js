use banking;

db.users.drop();
db.users.save({ userId : 'sraj', password:'password', lastLoginDate:'10/12/2009', lastLoginTime:'10:24 AM ET',profileId:'3604F6E6-87E8-41C2-BF55-06C61F63CF99', tenantId:'C63A953AE20D404F8BB1F225CBC82CF0', createdDate:new Date('03/28/2009'), createdBy:'syam',   "role" : {
    "primary" : "CUSTOMER"
  } });
db.users.save({ userId : 'sraj1', password:'password', lastLoginDate:'10/12/2009', lastLoginTime:'10:24 AM ET',profileId:'C3B62A95-2F72-4253-90F2-8A971B54A63C', tenantId:'CCCEDA89EC74479AB5C20AF7ACCD789D', createdDate:new Date('03/28/2009'), createdBy:'syam', "role" : {
    "primary" : "CUSTOMER"
  }});

  db.users.save({ userId : 'admin', password:'password', lastLoginDate:'10/12/2009', lastLoginTime:'10:24 AM ET',profileId:'C3B62A95-2F72-4253-90F2-8A971B54A63C', tenantId:'039E8ED1-313A-412B-9ED4-DEE675FF544A', createdDate:new Date('03/28/2009'), createdBy:'syam', "role" : {
    "primary" : "TENANT-ADMIN"
  }});
  
 db.profile.save({ profileId:'C3B789KK95-2F72-4253-90F2-8A971B54A63C', firstName:'Syam', lastName:'Raj', dateOfBirth:new Date('08/02/1981'), sex:'M', tenantId:'039E8ED1-313A-412B-9ED4-DEE675FF544A', createdDate:new Date('03/28/2009'), createdBy:'syam' });
 
 db.users.save( 
{
  "userId" : "sraj2",
  "password" : "password",
  "lastLoginDate" : "10/12/2009",
  "lastLoginTime" : "10:24 AM ET",
  "profileId" : "C3B62A95-2F72-4253-90F2-8A971B54A63C",
  "tenantId" : "CCCEDA89EC74479AB5C20AF7ACCD789D",
  "createdDate" : ISODate("2009-03-28T07:00:00Z"),
  "createdBy" : "syam",
  "role" : {
    "primary" : "staff",
    "secondary" : "staff"
  }
}
);
db.profile.drop();
db.profile.save({ profileId:'3604F6E6-87E8-41C2-BF55-06C61F63CF99', firstName:'Syam', lastName:'Raj', dateOfBirth:new Date('08/02/1981'), sex:'M', tenantId:'C63A953AE20D404F8BB1F225CBC82CF0', createdDate:new Date('03/28/2009'), createdBy:'syam' });
db.profile.save({ profileId:'C3B62A95-2F72-4253-90F2-8A971B54A63C', firstName:'Syam', lastName:'Raj', dateOfBirth:new Date('08/02/1981'), sex:'M', tenantId:'CCCEDA89EC74479AB5C20AF7ACCD789D', createdDate:new Date('03/28/2009'), createdBy:'syam' });


db.account.drop();
db.account.save({ accountNo:'1235687898',  type:'Savings', balance:'23456.90', profileId:'3604F6E6-87E8-41C2-BF55-06C61F63CF99', tenantId:'C63A953AE20D404F8BB1F225CBC82CF0', createdDate:new Date('03/28/2009'), createdBy:'syam' });
db.account.save({ accountNo:'1235687810',  type:'Checkings', balance:'345.67', profileId:'3604F6E6-87E8-41C2-BF55-06C61F63CF99', tenantId:'C63A953AE20D404F8BB1F225CBC82CF0', createdDate:new Date('03/28/2009'), createdBy:'syam' });

db.transaction.drop();
db.transaction.save({accountNo:'1235687810', date:new Date('03/28/2009'), description:'test', type:'CR', mode:'check', status:'Processed', amount:'234', availableBalance:'43434', tenantId:'C63A953AE20D404F8BB1F225CBC82CF0', createdDate:new Date('03/28/2009'), createdBy:'syam'});
db.transaction.save({accountNo:'1235687810', date:new Date('05/28/2009'), description:'test', type:'CR', mode:'check', status:'Processed', amount:'2340', availableBalance:'434340', tenantId:'C63A953AE20D404F8BB1F225CBC82CF0', createdDate:new Date('03/28/2009'), createdBy:'syam'});
db.transaction.save({accountNo:'1235687898', date:new Date('03/28/2009'), description:'test', type:'CR', mode:'check', status:'Processed', amount:'234', availableBalance:'43434', tenantId:'C63A953AE20D404F8BB1F225CBC82CF0', createdDate:new Date('03/28/2009'), createdBy:'syam'});
db.transaction.save({accountNo:'1235687898', date:new Date('05/28/2009'), description:'test', type:'CR', mode:'check', status:'Processed', amount:'2340', availableBalance:'434340', tenantId:'C63A953AE20D404F8BB1F225CBC82CF0', createdDate:new Date('03/28/2009'), createdBy:'syam'});
