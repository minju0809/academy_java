let http = require('http');
let express = require('express');
let app = express();

let items = [
  { name: '우유', price: '2000', etc: '몸에 좋은 우유' },
  { name: '홍차', price: '3000', etc: '몸에 좋은 홍차' },
  { name: '커피', price: '4000', etc: '몸에 좋은 커피' },
  { name: '쌍화차', price: '4500', etc: '몸에 좋은 쌍화차' }
];

app.use(express.bodyParser());
app.use(express.static('public')); // 폴더 접근
app.use(app.router);

app.all('/data.xml', (request, response) => {
  let output = '';
  output += '<?xml version="1.0" encoding="UTF-8" ?>';
  output += '<products>'
  items.forEach((item) => {
    output += '<product>'
    output += '<name>' + item.name + '</name>';
    output += '<price>' + item.price + '</price>';
    output += '<etc>' + item.etc + '</etc>';
    output += '</product>'
  });
  output += '</products>'
  response.type('text/xml');
  response.send(output);
});

app.all('/data.json', (request, response) => {
  response.send(items);
});

app.all('/data.html', (request, response) => {
  let output = "";
  items.forEach((item) => {
    output += `${item.name} :: ${item.price} <br>`;
  });
  response.send(output);
});

app.get('/detail/:idx', (request, response) => {
  console.log("ghkslelfji;a@@");
  let idx = Number(request.params.idx);
  idx = idx - 1;
  response.send(items[idx].etc);
});

app.post('/insert', (request, response) => {
  let name = request.body.name;
  let price = request.body.price;
  let item = { name: name, price: price };
  items.push(item);

  response.send({
    message: '데이터를 추가했습니다.', data: item
  });
});

app.get('/select', (request, response) => {
  response.send(items);
});

app.del('/delete/:idx', function (request, response) {
  var idx = Number(request.params.idx);
  idx = idx - 1;
  if (isNaN(idx)) {
    response.send({ error: '숫자를 입력하세요!!' });
  } else if (items[idx]) {
    items.splice(idx, 1);
    response.send({ message: '데이터를 삭제 했습니다.!' });
  } else {
    response.send({ error: '존재하지 않는 데이터입니다.!' });
  }
});

app.put('/edit', (request, response) => {
  let idx = request.body.idx;
  idx = idx - 1;
  let name = request.body.name;
  let price = request.body.price;

  if (isNaN(idx)) {
    response.send({ error: '숫자를 입력하세요!!' });
  } else if (items[idx]) {
    if (name) { items[idx].name = name; }
    if (price) { items[idx].price = price; }
    response.send({ message: '데이터를 수정했습니다.', data: items[idx] });
  } else {
    response.send({ error: '존재하지 않는 데이터 입니다.' });
  }
});

app.use((request, response, next) => {
  response.send('<h1> Hello Middleware ...! </h1>');
});

http.createServer(app).listen(52273, () => {
  console.log('Server Running at http://127.0.0.1:52273');
});
