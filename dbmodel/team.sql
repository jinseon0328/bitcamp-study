-- 회원
DROP TABLE IF EXISTS member RESTRICT;

-- 핫플레이스
DROP TABLE IF EXISTS hotp RESTRICT;

-- 신고게시판
DROP TABLE IF EXISTS b_notify RESTRICT;

-- 할인정보
DROP TABLE IF EXISTS sale RESTRICT;

-- 클럽게시판
DROP TABLE IF EXISTS club RESTRICT;

-- 게시판
DROP TABLE IF EXISTS board RESTRICT;

-- 게시판 댓글
DROP TABLE IF EXISTS b_reply RESTRICT;

-- 관리자
DROP TABLE IF EXISTS admin RESTRICT;

-- QnA게시판
DROP TABLE IF EXISTS m_qna RESTRICT;

-- 답변게시판
DROP TABLE IF EXISTS a_qna RESTRICT;

-- 탈퇴회원정보
DROP TABLE IF EXISTS m_delete RESTRICT;

-- FAQ게시판
DROP TABLE IF EXISTS b_faq RESTRICT;

-- 회원
CREATE TABLE member (
  mno     INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  mname   VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  mpwd    VARCHAR(100) NOT NULL COMMENT '암호', -- 암호
  memail  VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  mbirth  DATE         NOT NULL COMMENT '생년월일', -- 생년월일
  mgender INTEGER      NOT NULL COMMENT '성별', -- 성별
  mphoto  VARCHAR(255) NULL     COMMENT '사진', -- 사진
  mpost   VARCHAR(7)   NOT NULL COMMENT '우편번호', -- 우편번호
  maddr   VARCHAR(255) NOT NULL COMMENT '주소', -- 주소
  mdet    VARCHAR(255) NOT NULL COMMENT '상세주소' -- 상세주소
)
COMMENT '회원';

-- 회원
ALTER TABLE member
  ADD CONSTRAINT PK_member -- 회원 기본키
    PRIMARY KEY (
      mno -- 회원번호
    );

-- 회원
ALTER TABLE member
  ADD CONSTRAINT CK_member -- 회원 체크 제약
    CHECK (mgender = 1 or mgender = 0);

ALTER TABLE member
  MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 핫플레이스
CREATE TABLE hotp (
  hno      INTEGER      NOT NULL COMMENT '게시판 번호', -- 게시판 번호
  ano      INTEGER      NOT NULL COMMENT '관리자번호', -- 관리자번호
  htitle   VARCHAR(255) NOT NULL COMMENT '게시판 제목', -- 게시판 제목
  hcontent LONGTEXT     NOT NULL COMMENT '게시판 내용', -- 게시판 내용
  hdate    DATE         NOT NULL COMMENT '등록 날짜', -- 등록 날짜
  hcount   INTEGER      NOT NULL COMMENT '조회수', -- 조회수
  hphoto   VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '핫플레이스';

-- 핫플레이스
ALTER TABLE hotp
  ADD CONSTRAINT PK_hotp -- 핫플레이스 기본키
    PRIMARY KEY (
      hno -- 게시판 번호
    );

ALTER TABLE hotp
  MODIFY COLUMN hno INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시판 번호';

-- 신고게시판
CREATE TABLE b_notify (
  b_nno     INTEGER  NOT NULL COMMENT '신고게시판번호', -- 신고게시판번호
  bno       INTEGER  NULL     COMMENT '게시판id', -- 게시판id
  b_nreason LONGTEXT NOT NULL COMMENT '신고 사유', -- 신고 사유
  b_nresult INTEGER  NULL     COMMENT '처리결과' -- 처리결과
)
COMMENT '신고게시판';

-- 신고게시판
ALTER TABLE b_notify
  ADD CONSTRAINT PK_b_notify -- 신고게시판 기본키
    PRIMARY KEY (
      b_nno -- 신고게시판번호
    );

-- 신고게시판
ALTER TABLE b_notify
  ADD CONSTRAINT CK_b_notify -- 신고게시판 체크 제약
    CHECK (b_nresult = 1 or b_nresult = 0);

ALTER TABLE b_notify
  MODIFY COLUMN b_nno INTEGER NOT NULL AUTO_INCREMENT COMMENT '신고게시판번호';

-- 할인정보
CREATE TABLE sale (
  sno      INTEGER      NOT NULL COMMENT '게시판 번호', -- 게시판 번호
  ano      INTEGER      NOT NULL COMMENT '관리자번호', -- 관리자번호
  stitle   VARCHAR(255) NOT NULL COMMENT '게시판 제목', -- 게시판 제목
  scontent LONGTEXT     NOT NULL COMMENT '게시판 내용', -- 게시판 내용
  sdate    DATETIME     NOT NULL DEFAULT now() COMMENT '등록 날짜', -- 등록 날짜
  scount   INTEGER      NOT NULL COMMENT '조회수', -- 조회수
  sphoto   VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '할인정보';

-- 할인정보
ALTER TABLE sale
  ADD CONSTRAINT PK_sale -- 할인정보 기본키
    PRIMARY KEY (
      sno -- 게시판 번호
    );

ALTER TABLE sale
  MODIFY COLUMN sno INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시판 번호';

-- 클럽게시판
CREATE TABLE club (
  cno    INTEGER     NOT NULL COMMENT '클럽게시판번호', -- 클럽게시판번호
  mno    INTEGER     NOT NULL COMMENT '회원번호', -- 회원번호
  arrive VARCHAR(10) NOT NULL COMMENT '도착지', -- 도착지
  theme  VARCHAR(10) NOT NULL COMMENT '테마', -- 테마
  sdate  DATE        NOT NULL COMMENT '출발날짜', -- 출발날짜
  edate  DATE        NOT NULL COMMENT '도착날짜', -- 도착날짜
  mtotal INTEGER     NOT NULL COMMENT '인원수', -- 인원수
  mjoin  INTEGER     NOT NULL COMMENT '현재참여인원' -- 현재참여인원
)
COMMENT '클럽게시판';

-- 클럽게시판
ALTER TABLE club
  ADD CONSTRAINT PK_club -- 클럽게시판 기본키
    PRIMARY KEY (
      cno -- 클럽게시판번호
    );

ALTER TABLE club
  MODIFY COLUMN cno INTEGER NOT NULL AUTO_INCREMENT COMMENT '클럽게시판번호';

-- 게시판
CREATE TABLE board (
  bno      INTEGER      NOT NULL COMMENT '게시판id', -- 게시판id
  mno      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  btitle   VARCHAR(255) NOT NULL COMMENT '게시판 제목', -- 게시판 제목
  bcount   INTEGER      NOT NULL COMMENT '조회수', -- 조회수
  bcontent LONGTEXT     NOT NULL COMMENT '게시판내용', -- 게시판내용
  btype    INTEGER      NOT NULL COMMENT '게시판종류', -- 게시판종류
  bname    VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  bdate    DATETIME     NOT NULL DEFAULT now() COMMENT '작성일', -- 작성일
  bstatus  INTEGER      NULL     COMMENT '판매현황', -- 판매현황
  bphoto   VARCHAR(255) NULL     COMMENT '사진' -- 사진
)
COMMENT '게시판';

-- 게시판
ALTER TABLE board
  ADD CONSTRAINT PK_board -- 게시판 기본키
    PRIMARY KEY (
      bno -- 게시판id
    );

-- 게시판
ALTER TABLE board
  ADD CONSTRAINT CK_board -- 게시판 체크 제약
    CHECK (bstatus = 1 or bstatus = 0);

-- 게시판
ALTER TABLE board
  ADD CONSTRAINT CK_board2 -- 게시판 체크 제약2
    CHECK (btype = 1 or btype = 2 or btype = 3);

ALTER TABLE board
  MODIFY COLUMN bno INTEGER NOT NULL AUTO_INCREMENT COMMENT '게시판id';

-- 게시판 댓글
CREATE TABLE b_reply (
  b_rno      INTEGER  NOT NULL COMMENT '댓글 번호', -- 댓글 번호
  mno        INTEGER  NOT NULL COMMENT '회원번호', -- 회원번호
  bno        INTEGER  NOT NULL COMMENT '게시판id', -- 게시판id
  b_rdate    DATETIME NOT NULL DEFAULT now() COMMENT '작성일자', -- 작성일자
  b_rcontent LONGTEXT NOT NULL COMMENT '댓글 내용' -- 댓글 내용
)
COMMENT '게시판 댓글';

-- 게시판 댓글
ALTER TABLE b_reply
  ADD CONSTRAINT PK_b_reply -- 게시판 댓글 기본키
    PRIMARY KEY (
      b_rno -- 댓글 번호
    );

ALTER TABLE b_reply
  MODIFY COLUMN b_rno INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글 번호';

-- 관리자
CREATE TABLE admin (
  ano    INTEGER      NOT NULL COMMENT '관리자번호', -- 관리자번호
  aemail VARCHAR(40)  NOT NULL COMMENT '관리자이메일', -- 관리자이메일
  apwd   VARCHAR(100) NOT NULL COMMENT '관리자비밀번호' -- 관리자비밀번호
)
COMMENT '관리자';

-- 관리자
ALTER TABLE admin
  ADD CONSTRAINT PK_admin -- 관리자 기본키
    PRIMARY KEY (
      ano -- 관리자번호
    );

ALTER TABLE admin
  MODIFY COLUMN ano INTEGER NOT NULL AUTO_INCREMENT COMMENT '관리자번호';

-- QnA게시판
CREATE TABLE m_qna (
  m_qno      INTEGER      NOT NULL COMMENT 'QnA번호', -- QnA번호
  mno        INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
  m_qdate    DATE         NOT NULL COMMENT '작성일', -- 작성일
  m_qcontent LONGTEXT     NOT NULL COMMENT '내용', -- 내용
  m_qtitle   VARCHAR(255) NOT NULL COMMENT '제목' -- 제목
)
COMMENT 'QnA게시판';

-- QnA게시판
ALTER TABLE m_qna
  ADD CONSTRAINT PK_m_qna -- QnA게시판 기본키
    PRIMARY KEY (
      m_qno -- QnA번호
    );

ALTER TABLE m_qna
  MODIFY COLUMN m_qno INTEGER NOT NULL AUTO_INCREMENT COMMENT 'QnA번호';

-- 답변게시판
CREATE TABLE a_qna (
  a_qno      INTEGER  NOT NULL COMMENT '답변게시판번호', -- 답변게시판번호
  ano        INTEGER  NOT NULL COMMENT '관리자번호', -- 관리자번호
  m_qno      INTEGER  NOT NULL COMMENT 'QnA번호', -- QnA번호
  a_qcontent LONGTEXT NOT NULL COMMENT '내용', -- 내용
  a_qdate    DATE     NOT NULL COMMENT '작성일' -- 작성일
)
COMMENT '답변게시판';

-- 답변게시판
ALTER TABLE a_qna
  ADD CONSTRAINT PK_a_qna -- 답변게시판 기본키
    PRIMARY KEY (
      a_qno -- 답변게시판번호
    );

ALTER TABLE a_qna
  MODIFY COLUMN a_qno INTEGER NOT NULL AUTO_INCREMENT COMMENT '답변게시판번호';

-- 탈퇴회원정보
CREATE TABLE m_delete (
  m_dno     INTEGER  NOT NULL COMMENT '탈퇴번호', -- 탈퇴번호
  mno       INTEGER  NOT NULL COMMENT '회원번호', -- 회원번호
  m_dreason LONGTEXT NOT NULL COMMENT '탈퇴사유', -- 탈퇴사유
  m_ddate   DATE     NOT NULL COMMENT '탈퇴일' -- 탈퇴일
)
COMMENT '탈퇴회원정보';

-- 탈퇴회원정보
ALTER TABLE m_delete
  ADD CONSTRAINT PK_m_delete -- 탈퇴회원정보 기본키
    PRIMARY KEY (
      m_dno -- 탈퇴번호
    );

ALTER TABLE m_delete
  MODIFY COLUMN m_dno INTEGER NOT NULL AUTO_INCREMENT COMMENT '탈퇴번호';

-- FAQ게시판
CREATE TABLE b_faq (
  fno      INTEGER      NOT NULL COMMENT 'FAQ번호', -- FAQ번호
  ano      INTEGER      NOT NULL COMMENT '관리자번호', -- 관리자번호
  ftitle   VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  fdate    DATE         NOT NULL COMMENT '작성일', -- 작성일
  fcontent LONGTEXT     NOT NULL COMMENT '내용' -- 내용
)
COMMENT 'FAQ게시판';

-- FAQ게시판
ALTER TABLE b_faq
  ADD CONSTRAINT PK_b_faq -- FAQ게시판 기본키
    PRIMARY KEY (
      fno -- FAQ번호
    );

ALTER TABLE b_faq
  MODIFY COLUMN fno INTEGER NOT NULL AUTO_INCREMENT COMMENT 'FAQ번호';

-- 핫플레이스
ALTER TABLE hotp
  ADD CONSTRAINT FK_admin_TO_hotp -- 관리자 -> 핫플레이스
    FOREIGN KEY (
      ano -- 관리자번호
    )
    REFERENCES admin ( -- 관리자
      ano -- 관리자번호
    );

-- 신고게시판
ALTER TABLE b_notify
  ADD CONSTRAINT FK_board_TO_b_notify -- 게시판 -> 신고게시판
    FOREIGN KEY (
      bno -- 게시판id
    )
    REFERENCES board ( -- 게시판
      bno -- 게시판id
    );

-- 할인정보
ALTER TABLE sale
  ADD CONSTRAINT FK_admin_TO_sale -- 관리자 -> 할인정보
    FOREIGN KEY (
      ano -- 관리자번호
    )
    REFERENCES admin ( -- 관리자
      ano -- 관리자번호
    );

-- 클럽게시판
ALTER TABLE club
  ADD CONSTRAINT FK_member_TO_club -- 회원 -> 클럽게시판
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES member ( -- 회원
      mno -- 회원번호
    );

-- 게시판
ALTER TABLE board
  ADD CONSTRAINT FK_member_TO_board -- 회원 -> 게시판
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES member ( -- 회원
      mno -- 회원번호
    );

-- 게시판 댓글
ALTER TABLE b_reply
  ADD CONSTRAINT FK_member_TO_b_reply -- 회원 -> 게시판 댓글
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES member ( -- 회원
      mno -- 회원번호
    );

-- 게시판 댓글
ALTER TABLE b_reply
  ADD CONSTRAINT FK_board_TO_b_reply -- 게시판 -> 게시판 댓글
    FOREIGN KEY (
      bno -- 게시판id
    )
    REFERENCES board ( -- 게시판
      bno -- 게시판id
    );

-- QnA게시판
ALTER TABLE m_qna
  ADD CONSTRAINT FK_member_TO_m_qna -- 회원 -> QnA게시판
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES member ( -- 회원
      mno -- 회원번호
    );

-- 답변게시판
ALTER TABLE a_qna
  ADD CONSTRAINT FK_m_qna_TO_a_qna -- QnA게시판 -> 답변게시판
    FOREIGN KEY (
      m_qno -- QnA번호
    )
    REFERENCES m_qna ( -- QnA게시판
      m_qno -- QnA번호
    );

-- 답변게시판
ALTER TABLE a_qna
  ADD CONSTRAINT FK_admin_TO_a_qna -- 관리자 -> 답변게시판
    FOREIGN KEY (
      ano -- 관리자번호
    )
    REFERENCES admin ( -- 관리자
      ano -- 관리자번호
    );

-- 탈퇴회원정보
ALTER TABLE m_delete
  ADD CONSTRAINT FK_member_TO_m_delete -- 회원 -> 탈퇴회원정보
    FOREIGN KEY (
      mno -- 회원번호
    )
    REFERENCES member ( -- 회원
      mno -- 회원번호
    );

-- FAQ게시판
ALTER TABLE b_faq
  ADD CONSTRAINT FK_admin_TO_b_faq -- 관리자 -> FAQ게시판
    FOREIGN KEY (
      ano -- 관리자번호
    )
    REFERENCES admin ( -- 관리자
      ano -- 관리자번호
    );