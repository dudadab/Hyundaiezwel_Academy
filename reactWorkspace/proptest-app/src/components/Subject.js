import React from 'react';

// const Subject = ({title, sub}) => { //{}를 통해 매개변수 설정 title에 값을 전달
//     return (
//         <div>
//             <h1>{title}</h1>
//             {sub}
//         </div>
//     );
// };

const Subject = (props) => { //선택자에서 전달된 속성값을 매개변수 1개로 받으면 object 타입으로 받아짐
    // static defaultProps ={
    //     title: 'web'
    // } 클래스형 기능
    return (
        <div>
            <h1>{props.title}</h1>
            {props.sub}<br/>
            {props.content}<br/>
        </div>
    );
};

// Subject.defaultProps = {
//     title: 'WEB'
// }
export default Subject;