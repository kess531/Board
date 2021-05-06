'user script';
let arrowup__btn = document.querySelector('.arrowup__btn');
let header__logo = document.querySelector('.header__logo');

    //arrowup버튼
arrowup__btn.addEventListener('click',()=>{
    header__logo.scrollIntoView({behavior:"smooth"});
})
$(document).ready(function(){
    getBoardList();
});
    // 댓글 AJAX
    function getBoardList(){
        
        $.ajax({            
            type:'GET',
            url:'commentList',
            data :{   
                bltNo : $('.bltNoClass').val(),
                },
            dataType:'JSON',

            success : function(obj) {
                console.log('댓글 받아오기 성공~');
                console.log(obj);
                getCommentListCallback(obj);
            },           
            error : function(xhr, status, error) {
                console.log($('.bltNoClass').val());
            }
         });
    }


    function  getCommentListCallback(obj){
        const container__contentview__comment__content = document.querySelector('.container__contentview__comment__content');
        const container__contentview__comment__paging = document.querySelector('.container__contentview__comment__paging');
        container__contentview__comment__content.innerHTML='';
        let list = obj;
        let listLen = list.list.length;
        console.log(listLen);
       
        if(listLen>0){
            container__contentview__comment__paging.innerHTML='';
        for(let i =0; i<listLen; i++){
            let cmtNo = list.list[i].cmtNo;
            let cmtContent = list.list[i].cmtContent;
            let memberName = list.list[i].memberName;
            let cmtDate = list.list[i].cmtDate;
            const itemRow =document.createElement('li');
            itemRow.setAttribute('class','container__contentview__comment__content__wrap');
            itemRow.innerHTML=`
            <div class="container__contentview__comment__content__writer">${memberName}</div>
            <div class="container__contentview__comment__content__content">${cmtContent}</div>
            <div class="container__contentview__comment__content__date">${cmtDate}
            <input class="container__contentview__comment__content__deleteBtn" data-id="${cmtNo}" type="button" value="x"></div>
            `;
            container__contentview__comment__content.appendChild(itemRow);

            
        }
        
        for(let i=list.pagemaker.startPage; i<=list.pagemaker.endPage; i++){
            const pagingBtn = document.createElement('p');
            pagingBtn.setAttribute('class','contentView__Paging');
            pagingBtn.setAttribute('data-id',`${i}`);
            pagingBtn.innerHTML=`${i}`;
            container__contentview__comment__paging.appendChild(pagingBtn);
        }
    }
    else {
        console.log('댓글이없습니다.');
    }
       
    }
const container__contentview__comment__paging = document.querySelector('.container__contentview__comment__paging');
container__contentview__comment__paging.addEventListener('click',(e)=>{
        const targetid = e.target.dataset.id;
        e.target.classList.remove('now__paging');
        
        if(targetid)
        {
            $.ajax({            
                type:'GET',
                url:'commentList',
                data :{
                bltNo : $('.bltNoClass').val(),
                page : targetid
                },
                dataType:'JSON',
                success : function(obj) {
                    console.log('검색성공');
                    e.target.classList.add('now__paging');
                    getCommentListCallback(obj);                
                },           
                error : function(xhr, status, error) {
                    console.log('검색실패');
                }
                });
        }
    })

const container__contentview__comment__content = document.querySelector('.container__contentview__comment__content');
container__contentview__comment__content.addEventListener('click', (e)=>{
    const targetid = e.target.dataset.id;
    $.ajax({            
        type:'GET',
        url:'commentPwdSelect',
        data :{
        cmtNo : targetid
        },
        dataType:'JSON',
        success : function(obj) {
            
            passwordCheck(obj,targetid);
           
            
        },           
        error : function(xhr, status, error) {
            console.log('비밃번호 확인실패');
        }
        });
    

  

});

function passwordCheck(obj , targetid){
    let password = obj.cmtPwd;
            
    let returnValue = prompt('비밀번호를 입력해주세요');
    
    if(returnValue !==password){
        alert('잘못입력했슈!');
    }
    else{
        location.href=`commentDelete?cmtNo=${targetid}`;
    }
}