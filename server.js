let http = require('http'); 
let express = require('express');
let app = express();
let oracledb = require("oracledb");

app.use(express.logger());
app.use(express.bodyParser());
app.use(express.static('public'));
app.use(app.router);

//  오라클에서는 autoCommit 속성을 부여해야 적용된다.!!
oracledb.autoCommit = true;
oracledb.initOracleClient(); // 버전 문제 해결

let conn = null;
oracledb.getConnection({
  user: "system",
  password: "1234",
  connectString: "localhost/xe"
}, (err, con) => {
  if (err) {
    // console.log("접속 실패", err);
  } else {
    conn = con;
    // console.log("접속 성공", conn);
  }
});

app.get('/select/', function (request, response) {
  let SQL = "select * from memo1213 order by idx desc";
  conn.execute(SQL, function (err, data) {

    if (err) {
      console.log("==> 등록중 에러가 발생했어요!!", err);
      response.writeHead(500, { "ContentType": "text/html" });
      response.end("fail!!");
    } else {
      console.log("===> result : ", data);
      response.send(data.rows);
    }
  });
});

app.get('/selectMemo', (request, response) => {
  let idx = Number(request.query.idx);
  let SQL = "select memo from memo1213 where idx = :idx";
  conn.execute(SQL, [idx], function (err, data) {

    if (err) {
      console.log("==> 등록중 에러가 발생했어요!!", err);
      response.writeHead(500, { "ContentType": "text/html" });
      response.end("fail!!");
    } else {
      console.log("===> result : ", data);
      response.send(data.rows);
    }
  });
});



// app.get('/detail/', function (request, response) {
//   let idx = '101';
//   let SQL = "select * from memo1213 where idx = :idx";
//   conn.execute(SQL,[idx], function (err, data) {

//     if (err) {
//       console.log("==> 등록중 에러가 발생했어요!!", err);
//       response.writeHead(500, { "ContentType": "text/html" });
//       response.end("fail!!");
//     } else {
//       console.log("===> result : ", data);
//       response.send(data.rows);
//     }
//   });
// });

// app.get('/detail2/', function (request, response) {
//   let idx = '102';
//   let SQL = "select * from memo1213 where idx = " + idx;
//   conn.execute(SQL, function (err, data) {

//     if (err) {
//       console.log("==> 등록중 에러가 발생했어요!!", err);
//       response.writeHead(500, { "ContentType": "text/html" });
//       response.end("fail!!");
//     } else {
//       console.log("===> result : ", data);
//       response.send(data.rows);
//     }
//   });
// });

app.post('/insert/', function (request, response) {
  let writer = request.body.writer;
  let memo = request.body.memo;
  let SQL = "insert into memo1213 (idx, writer, memo) values (idx.nextval, :writer, :memo)";
  conn.execute(SQL, [writer, memo], function (err, data) {

    if (err) {
      console.log("==> 등록중 에러가 발생했어요!!", err);
      response.writeHead(500, { "ContentType": "text/html" });
      response.end("fail!!");
    } else {
      console.log("===> result(저장성공) : ", data);
      response.send(data.rows);
    }
  });
});


app.all('/delete/:idx', function (request, response) {
  let idx = Number(request.params.idx);
  let SQL = "delete from memo1213 where idx = :idx";
  conn.execute(SQL,[idx], function (err, data) {

    if (err) {
      console.log("==> 등록중 에러가 발생했어요!!", err);
      response.writeHead(500, { "ContentType": "text/html" });
      response.end("fail!!");
    } else {
      console.log("===> result(삭제성공) : ", data);
      response.send(data.rows);
    }
  });
});


http.createServer(app).listen(52273, function () {
  console.log('Server Running  at  http://127.0.0.1:52273');
});





//////////////////////////////////////////////////////

var mysql = require('mysql');

var client = mysql.createConnection({
  user: 'root',
  password: 'autoset',
  database: 'node'
});

client.query('select * from  memo1213', function (error, result, fields) {
  if (error) {
    // console.log('쿼리 문장에 오류가 있습니다.');
  } else {
    // console.log(result);
  }
});
