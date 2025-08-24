function add(num1:number,num2:number):number{
    return num1+num2;
}
function sub(num1:number,num2:number):number{
    return num1-num2;
}
function mul(num1:number,num2:number):number{
    return num1*num2;
}
function div(num1:number,num2:number):number{
    return num1/num2;
}

enum direction{
    up=0,
    down =1,
    left = -1,
    right= 1
}

let user:{name:number,gender:string};

let id: number|string;
id = 10;
id = "hello";

type Gender = "Male" | "Female";

type Point={
    x:number;
    y:number;
}
// console.log(direction.down+direction.right); 
   
// console.log("Addition is "+add(10,20));
// console.log("Subtraction is "+sub(10,20));
// console.log("Addition is "+mul(10,20));
// console.log("Division is is "+div(10,20));


// let ans:string="";
// for(let i:number =0;i<7;i++){
//     let temp:number= 1;
//     let k:number = i;
//     if(k>3)k=7-k-1;
//     for(let j:number=0;j<=k;j++){
//         ans += temp;
//         ans+=" ";
//         temp*=5;
//     }
//     console.log(ans);
//     ans = "";
// }


// function greet(firstname:string,defaultparam: string = "hello",lastname?:string){
//     if(lastname)
//         console.log(`helo`)
// }

class plant{
    name:string;
    color:string = "red";
    age:number;
    constructor(name,color?,age=0){
        if(color){
            this.color = color;
        }
        this.name=name;
        this.age=age;
    }
    show(){
        console.log("name : "+ this.name,"\ncolor : "+this.color,"\nage"+this.age);
    }
}

let p1:plant=new plant("q",10);
let p2:plant=new plant("w","green");

p1.show();
p2.show();


// // file: calculator.ts
// export function add(a: number, b: number): number {
// return a + b;
// }

// // file: app.ts
// import { add } from "./calculator";
// let result = add(5, 3);
// console.log(result); // 8


async function age(name) {
    const response = await fetch(`https://api.agify.io/?name=${name}`);
    const data = await response.json();
    console.log(data);
}

let op:number=1;
while(op){
    let userInput = prompt("Enter your input:");
    if(userInput=="0")break;
     age(userInput);

}
