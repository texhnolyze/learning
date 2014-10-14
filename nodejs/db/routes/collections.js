var express = require('express')
var router = express.Router()
var db = require('mongoskin').db('mongodb://localhost:27017/node')

router.param('collectionName', function(req, res, next, collectionName){
    console.log('param collectionName: ' + collectionName + ' working');
    req.collection = db.collection(collectionName)
    req.name = collectionName;
    next()
})

router.param('id', function(req, res, next, id){
    console.log('param id: ' + id + ' working')
    req.id = id;
    next()
})

router.get('/:collectionName', function(req, res){
    req.collection.find({}).toArray(function(err, result){
        if (err) next(err);
        console.log(result);
        res.send(result)
    })
});

router.get('/:collectionName/:id', function(req, res){
    req.collection.findById(req.id, function(err, result){
        if (err) next(err);
        res.send(result)
    })
})

router.post('/:collectionName', function(req, res){
    req.collection.insert(req.body, {}, function(err, result){
        if (err) next(err);
        res.send(result);
    });
});

router.get('/', function(req, res){
    res.send('give a collection name as url e.g /:collection')
})

function test (error, result){
    if (error) throw error;
    x = result;
};

module.exports = router;
