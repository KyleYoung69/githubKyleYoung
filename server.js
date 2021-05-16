const express = require('express')
const logger = require('morgan')
const path = require('path')
const server = express()
server.use(express.urlencoded({'extended': true}))
server.use(logger('dev'))

// Routes



server.post('/cs212/homework/8/', (req, res) => {
	madlib = ( `<h1>THE STORY </h1><p> THE ${req.body['adj1']} -ish ${req.body['noun1']} did the ${req.body['verb1']} on the ${req.body['adj2']} -ish ${req.body['noun2']} and then they all died the end. </p>` )
	res.send(madlib)
})
server.post('/lightsout', (req,res) => {
	res.send('/cs212/final')
})
// Setup static page serving for all the pages in "public"
const publicServedFilesPath = path.join(__dirname, 'public')
server.use(express.static(publicServedFilesPath))


// The server uses port 80 by default unless you start it with the extra
// command line argument 'local' like this:
//       node server.js local
let port = 80
if (process.argv[2] === 'local') {
  port = 8080
}

server.listen(port, () => console.log('Ready on localhost!'))
