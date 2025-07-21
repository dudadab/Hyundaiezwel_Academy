import React from 'react';
import {useParams} from 'react-router-dom';

const Book = (props) => {
    const params = useParams();
    const book_ar = props.books;
    const book = book_ar[parseInt(params.keyword)-1];
    return (
        <div>
            도서명 : {book.title} <br/>
            저자 : {book.writer} <br/>
        </div>
    );
};

export default Book;