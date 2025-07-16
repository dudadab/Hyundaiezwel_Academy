/* slideShow.js*/

$(function(){
    //이동한 이미지의 index 값 저장 변수(현재 이미지)
    let moveIndex = 0;

    //슬라이드 패널을 움직여주는 함수
    function moveSlide(index){
        //전달받은 index값을 moveIndex에 저장
        moveIndex = index;

        let moveLeft  = -(index * 1280)
        $('#slidePanel').animate({'left':moveLeft}, 'slow');
    }

    //prev 버튼 클릭하면 앞으로 이동
    $('#prevButton').on('click', function(){
        if(moveIndex!=0)
            moveIndex = moveIndex - 1;

        moveSlide(moveIndex);
    });

    //next 버튼 클릭하면 뒤로 이동
    $('#nextButton').on('click', function(){
        if(moveIndex!=4)
            moveIndex = moveIndex + 1;

        moveSlide(moveIndex);
    });

    let randomNumber = Math.floor(Math.random() * 5);
    moveSlide(randomNumber);
    
    //각 컨트롤 버튼에 대해
    $('.controlButton').each(function(index){
        $(this).hover(
            function(){
                $(this).attr('src', 'image/controlButton2.png');
            },
            function(){
                $(this).attr('src', 'image/controlButton1.png');
            }
        );
        $(this).on('click', function(){
            moveSlide(index);
        }) //click 끝
    }); //each 끝
    setInterval(function() { moveIndex = (moveIndex + 1) % 5; moveSlide(moveIndex); }, 3000);
}); //ready 끝