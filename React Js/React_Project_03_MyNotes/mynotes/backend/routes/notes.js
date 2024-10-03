const express = require('express')

const router = express.Router();

router.get('/', (req, res) => {
    obj = {
        any: 'hey',
        number: 28
    }
    res.json(obj)
})

module.exports = router