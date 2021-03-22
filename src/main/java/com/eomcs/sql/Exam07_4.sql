/* union 과 union all */

/* select 결과 합치기 
   union : 중복 값 자동 제거*/
select distinct bank from stnt
union /*오라클은 union, minus, intersect 모두 다 사용가능하다*/
select distinct bank from tcher;

/* union all: 중복 값 제거 안함*/
select distinct bank from stnt
union all
select distinct bank from tcher;







