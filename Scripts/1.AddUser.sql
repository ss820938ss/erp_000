-- 계정 권한 부여
grant all 
   on erp_000.* 
   to 'user_erp_000'@'localhost' identified by 'rootroot';

-- file 권한(backup, load) -- root만 권한 부여 가능
GRANT File 
   ON *.* 
   TO 'user_erp_000'@'localhost';
   