import React from 'react';
import Main from './Main';

const App = () => {
  const fruits2 = ["사과", "바나나", "포도"]
  const nameList = fruits2.map((name) => (<Main name={name}/>))
  
  // filter() 예제 코드
const fruits = [
  { id: 1, name: '사과', type: '온대' },
  { id: 4, name: '포도', type: '온대' },
  { id: 7, name: '바나나', type: '열대' },
  { id: 12, name: '망고', type: '열대' },
  { id: 54, name: '파인애플', type: '열대' }
];

const tropicalFruits = fruits.filter(fruit => fruit.type === '열대');

return (
    <div>
    {nameList}
    <hr/>
    <h2>열대 과일:</h2>
    <ul>
      {tropicalFruits.map(fruit => (
        <li key={fruit.id}>{fruit.name}</li>
      ))}
    </ul>
  </div>
  );
}

export default App;
