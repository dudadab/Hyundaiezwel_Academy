function Student(props) {
  return (
    <div>
      <h2>학생 정보</h2>
      <p>이름: {props.name}</p>
      <p>나이: {props.age}</p>
      <p>학년: {props.year}</p>
      <p>주소: {props.address}</p>
    </div>
  );
}

export default Student;
