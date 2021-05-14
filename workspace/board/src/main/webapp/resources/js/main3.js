'user script';
let arrowup__btn = document.querySelector('.arrowup__btn');
let header__logo = document.querySelector('.header__logo');

    //arrowup버튼
arrowup__btn.addEventListener('click',()=>{
    header__logo.scrollIntoView({behavior:"smooth"});
})


const container__contentview__board__type = document.querySelector('.container__contentview__board__type');

let board__Type = container__contentview__board__type.innerHTML;

if(board__Type ==='free'){
    container__contentview__board__type.innerHTML='자유';
}
else if(board__Type ==='qna'){
    container__contentview__board__type.innerHTML='질문';
}
else{
    container__contentview__board__type.innerHTML='구직';
}


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


   
const container__contentview__comment__paging = document.querySelector('.container__contentview__comment__paging');
container__contentview__comment__paging.addEventListener('click',(e)=>{
        const targetid = e.target.dataset.id;

        
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
                 
                    getCommentListCallback(obj);                
                },           
                error : function(xhr, status, error) {
                    console.log('검색실패');
                }
                });
        }
    });

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
            console.log('비밀번호 확인실패');
        }
        });
    

  

});

const container__contentview__board__content__deleteBtn = document.querySelector('.container__contentview__board__content__deleteBtn');
container__contentview__board__content__deleteBtn.addEventListener('click',()=>{
    let returnValue = confirm('정말 삭제하시겠습니까?');
    const container__contentview__board__no = document.querySelector('.container__contentview__board__no');
    const bltNo= container__contentview__board__no.innerHTML;
    if(returnValue ===true){
        console.log('삭제요청완료');
        location.href=`contentDelete?bltNo=${bltNo}`;
    }
    
});


function passwordCheck(obj , targetid){
    let password = obj.cmtPwd;
            
    let returnValue = prompt('비밀번호를 입력해주세요');
    
    if(returnValue !==password){
        alert('비밀번호를 확인해주세요.');
    }
    else{
        location.href=`commentDelete?cmtNo=${targetid}`;
        alert('삭제했습니다.');
    }
}

function  getCommentListCallback(obj){
    const container__contentview__comment__content = document.querySelector('.container__contentview__comment__content');
    const container__contentview__comment__paging = document.querySelector('.container__contentview__comment__paging');
    container__contentview__comment__content.innerHTML='';
    container__contentview__comment__paging.innerHTML='';
    let list = obj;
    let listLen = list.list.length;
    console.log(listLen);
   
    if(listLen>0){
        
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
    
    if(list.pagemaker.prev==true){

        const firstPage = list.pagemaker.startPage - 1;
        const prevBtn = document.createElement('p');
        prevBtn.setAttribute('class','contentView__Paging');
        prevBtn.setAttribute('data-id',`${firstPage}`);
        prevBtn.innerHTML='이전';
        container__contentview__comment__paging.appendChild(prevBtn);
    }

    for(let i=list.pagemaker.startPage; i<=list.pagemaker.endPage; i++){

        if(i===list.pagemaker.cmt.page){
            const pagingBtn = document.createElement('p');
            pagingBtn.setAttribute('class','contentView__Paging__now');
            pagingBtn.setAttribute('data-id',`${i}`);
            pagingBtn.innerHTML=`${i}`;
            container__contentview__comment__paging.appendChild(pagingBtn);
        }
        else{
            const pagingBtn = document.createElement('p');
            pagingBtn.setAttribute('class','contentView__Paging');
            pagingBtn.setAttribute('data-id',`${i}`);
            pagingBtn.innerHTML=`${i}`;
            container__contentview__comment__paging.appendChild(pagingBtn);
        }
        
    }

    if(list.pagemaker.next==true){
        const lastPage = list.pagemaker.endPage + 1;
        const nextBtn = document.createElement('p');
        nextBtn.setAttribute('class','contentView__Paging');
        nextBtn.setAttribute('data-id',`${lastPage}`);
        nextBtn.innerHTML='다음';
        container__contentview__comment__paging.appendChild(nextBtn);
    }
}
else {
    console.log('댓글이없습니다.');
    container__contentview__comment__paging.innerHTML='댓글이 없습니다.';
}   
   
}