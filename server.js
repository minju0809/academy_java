let http = require('http');
let express = require('express');

let items = [
  { name: '우유', price: '2000' },
  { name: '홍차', price: '3000' },
  { name: '커피', price: '4000' }
];

let app = express();

// 웹 서버를 생성합니다.
// app.use((request, response) => {
//      response.send ('<h1> 서버 접근을 환영합니다.!! </h1>');
// });
/////////////////////////////////////////////////////////////

// app.use((request, response, next) => {
//   console.log('first');
//   next();
// });

// app.use((request, response, next) => {
//   console.log('second');
//   next();
// });

// app.use((request, response , next) => {
//   response.send('<h1> Hello Middleware ...! </h1>');
// });     
/////////////////////////////////////////////////////////////

// app.use((request, response , next) => {
//   request.id = 'kang';
//   response.pwd = '1234';
//   next(); 
// });

// app.use((request, response , next) => {
//   response.send(`<h1> ${request.id} :: ${response.pwd} </h1>`);
// });
/////////////////////////////////////////////////////////////
// 많이 사용하는 미들웨어
// app.use(express.logger());
app.use(express.bodyParser());
// app.use(express.cookieParser());
// app.use(express.session());
app.use(express.static('public')); // 폴더 접근
app.use(app.router);

// app.use((request, response, next) => {
//   response.send('<h1> Hello Middleware ...! </h1>');
// });

// app.all('/a', (request, response) => {
//   response.send('<h1> Page A </h1>')
// });

// app.get('/b', (request, response) => {
//   response.send('<h1> Page B - get </h1>')
// });

// app.post('/b', (request, response) => {
//   response.send('<h1> Page B = post </h1>')
// });

// app.all('/b', (request, response) => {
//   response.send('<h1> Page B - all </h1>')
// });
/////////////////////////////////////////////////////////////
// 동적 라우팅 영역
app.get('/select/:idx', (request, response) =>{
  let idx = Number(request.params.idx);

  if (isNaN(idx)) {
      response.send({ error:'숫자를 입력하세요!!'});
   }else if (items[idx]) {
    response.send({ data: items[idx] });
  } else {
    response.send({ error:'존재하지 않는 데이터 입니다.'});
  }
});

app.post('/edit', (request, response) =>{
  let idx = request.body.idx;
  let name = request.body.name;
  let price = request.body.price;

  if (isNaN(idx)) {
      response.send({ error:'숫자를 입력하세요!!'});
   }else if (items[idx]) {
    if(name) {items[idx].name = name;}
    if(price) {items[idx].price = price;}
    response.send({ message:'데이터를 수정했습니다.', data: items[idx]});
  } else {
    response.send({ error:'존재하지 않는 데이터 입니다.'});
  }
});

app.get('/delete', (request, response) => {
  let idx = Number(request.query.idx);
  if (isNaN(idx)) {
    response.send({ error: '숫자를 입력하세요!!' });
  } else if (items[idx]) {
    items.splice(idx, 1);
    response.send({ message: '데이터를 삭제했습니다.' });
  } else {
    response.send({ error: '존재하지 않는 데이터 입니다.' });
  }
});

app.del('/products/:idx', (request, response) => {
  let idx = Number(request.param('idx'));

  if (isNaN(idx)) {
    response.send({ error: '숫자를 입력하세요!!' });
  } else if (items[idx]) {
    items.splice(idx, 1);
    response.send({ message: '데이터를 삭제 했습니다.!' });

  } else {
    response.send({ error: '존재하지 않는 데이터입니다.!' });
  }
});

app.post('/products', (request, response) => {
  let name = request.body.name;
  let price = request.body.price;
  let item = { name: name, price: price };
  items.push(item);

  response.send({
    message: '데이터를 추가했습니다.', data: item
  });
});

app.put('/products/:idx', (request, response) =>{
  let idx = Number(request.params.idx);
  let name = request.query.name;
  let price = request.query.price;

  if (isNaN(idx)) {
      response.send({ error:'숫자를 입력하세요!!'});
   }else if (items[idx]) {
    if(name) {items[idx].name = name;}
    if(price) {items[idx].price = price;}
    response.send({ message:'데이터를 수정했습니다.', data: items[idx]});
  } else {
    response.send({ error:'존재하지 않는 데이터 입니다.'});
  }
});

app.get('/products', (request, response) => {
  response.send(items);
});

app.all('/parameter/:id', (request, response) => {
  let id = request.params.id;
  if (id == 'kang') {
    response.send('<h1>' + id + '</h1>');
  } else {
    response.send('<h1>' + "로그인 실패!!" + '</h1>');
  }
});

app.all('/parameter', (request, response) => {
  let name = request.query.name;
  let region = request.query.region;
  response.send('<h1>' + name + ' : ' + region + '</h1>');
});

app.all('/data.xml', (request, response) => {
  let output = '';
  output += '<?xml version="1.0" encoding="UTF-8" ?>';
  output += '<products>'
  items.forEach((item) => {
    output += '<product>'
    output += '<name>' + item.name + '</name>';
    output += '<price>' + item.price + '</price>';
    output += '</product>'
  });
  output += '</products>'
  response.type('text/xml');
  response.send(output);
});


app.all('/data.json', (request, response) => {
  response.send(items);
});

app.post('/data.html', (request, response) => {
  let output = "";
  items.forEach((item) => {
    output += `${item.name} AA ${item.price} <br>`;
  });
  response.send(output);
});

app.all('/data.html', (request, response) => {
  let output = "";
  items.forEach((item) => {
    output += `${item.name} :: ${item.price} <br>`;
  });
  response.send(output);
});

http.createServer(app).listen(52273, () => {
  console.log('Server Running at http://127.0.0.1:52273');
});
