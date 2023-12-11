let output = "";
for (let i = 0; i < 10; i++) {
  console.log(output += '*');
}

let os = require('os');

// console.log(os.hostname());
// console.log(os.type());
// console.log(os.cpus());
// console.log(os.networkInterfaces());

const http = require('http');

const hostname = '127.0.0.1';
const port = 3001;

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hello World!\n');
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
})

let fs = require('fs');
let content = fs.readFileSync("readme.txt", "utf-8");
console.log(content);
console.log('파일 읽기...');
console.log('----------------------------');
//////////////////////////////////
let fs2 = require('fs');
fs2.readFile("readme.txt", "utf-8", function(err, content) {
    console.log(content);
});
console.log('파일 읽기...');
