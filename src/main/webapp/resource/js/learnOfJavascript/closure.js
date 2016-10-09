// 1.
function foo(x) {
    var tmp = 3;

    function bar(y) {
        alert(x + y + (++tmp));
    }

    bar(10);
}
foo(2); //16
foo(2); //16
foo(2); //16

// 2.
function foo(x) {
    var tmp = 3;
    return function (y) {
        alert(x + y + (++tmp));
    }
}
var bar = foo(2); // bar 现在是一个闭包
bar(10); //16
bar(10); //17
bar(10); //18

var bar1 = (function () {
    var tmp = 3;
    return function (y) {
        alert(x + y + (++tmp));
    }
})();


// 3.
var test = (function () {
    var data = {};
    return function (key, value) {
        if (data[key] == null) {
            data[key] = value;
        } else {
            return value;
        }
    }
})();


// 4.
var db = (function () {
// 创建一个隐藏的object, 这个object持有一些数据
// 从外部是不能访问这个object的
    var data = {};
// 创建一个函数, 这个函数提供一些访问data的数据的方法
    return function (key, val) {
        if (val === undefined) {
            return data[key]
        } // get
        else {
            return data[key] = val
        } // set
    }
// 我们可以调用这个匿名方法
// 返回这个内部函数，它是一个闭包
})();

db('x'); // 返回 undefined
db('x', 1); // 设置data['x']为1
db('x'); // 返回 1
// 我们不可能访问data这个object本身
// 但是我们可以设置它的成员


// 5.
for (var i = 0; i < 4; i++) {
    var click = function () {
        alert(i);
    }
}

for (var i = 0; i < 4; i++) {
    (function (num) {
        alert(num)
    })(i);
}


// 6.
function Circle(r) {
    this.r = r;
}

Circle.PI = 3.14;

Circle.prototype.area = function () {
    return Circle.PI * this.r * this.r;
}

var c = new Circle(1);
c.area();

//7.
var Circle = function () {
    var obj = new Object();
    obj.PI = 3.14;

    obj.area = function (r) {
        return this.PI * r * r;
    }

    return obj;
}

//8.
var Circle = new Object();
Circle.PI = 3.14;
Circle.Area = function (r) {
    return this.PI * r * r;
}

//9.
var Circle = {
    'PI': 3.14,
    'area': function (r) {
        return this.PI * r * r;
    }
};


//10.
var fun = new Function('x', 'y', 'return x*y;');


//11.
function print(a, b, c, d) {
    alert(a + b + c + d);
}

function example(a, b, c, d) {
    //用call方式借用print,参数显式打散传递
    print.call(this, a, b, c, d);

    //用apply方式借用print, 参数作为一个数组传递,
    //这里直接用JavaScript方法内本身有的arguments数组
    print.apply(this, arguments);

    //或者封装成数组
    print.apply(this, [a, b, c, d]);
}

//下面将显示"背光脚本"
example("背", "光", "脚", "本");



//12.匿名函数
(function(){
    var foo = 20;
    var bar = 10;
    alert(foo + bar);
})();

$(function(){

})
