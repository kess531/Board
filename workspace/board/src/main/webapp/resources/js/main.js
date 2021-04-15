'user script';
var arrowup__btn = document.querySelector('.arrowup__btn');
var header__logo = document.querySelector('.header__logo');

    //arrowup버튼
arrowup__btn.addEventListener('click',()=>{
    header__logo.scrollIntoView({behavior:"smooth"});
})

const container__board__listview = document.querySelector('.container__board__listview');
const container__board__paging = document.querySelector('.container__board__paging');
$(document).ready(function(){
    getBoardList();
});
    // 게시글 AJAX
    function getBoardList(){
        
        $.ajax({            
            type:'GET',
            url:'bulletin/listView',
            dataType:'JSON',

            success : function(obj) {
                console.log('성공');
     
                getBoardListCallback(obj);                
            },           
            error : function(xhr, status, error) {}
         });
    }


    //페이징
container__board__paging.addEventListener('click',e=>{
    const targetid = e.target.dataset.id;

    if(targetid)
    {
        $.ajax({            
            type:'GET',
            url:'bulletin/listView',
            data :{
            page : targetid
            },
            dataType:'JSON',
            success : function(obj) {
                console.log('검색성공');
                
                getBoardListCallback(obj);                
            },           
            error : function(xhr, status, error) {
                console.log('검색실패');
            }
            });
    }
})

const container__subTitle__btn = document.querySelector('.container__subTitle__btn');

container__subTitle__btn.addEventListener('click', ()=>{
    $.ajax({            
        type:'GET',
        url:'bulletin/listView',
        data :{   
        keyword : $('.container__subTitle__text').val(),
        clsfcselect : $('.container__subTitle__select').val()},
        dataType:'JSON',
        success : function(obj) {
            console.log('검색성공');
            
            getBoardListCallback(obj);                
        },           
        error : function(xhr, status, error) {
            console.log('검색실패');
        }
        });


})


const container__subTitle__text = document.querySelector('.container__subTitle__text');
container__subTitle__text.addEventListener('keyup',()=>{
    $.ajax({            
        type:'GET',
        url:'bulletin/listView',
        data :{
    keyword : $('.container__subTitle__text').val(),
    clsfcselect : $('.container__subTitle__select').val()
},
        dataType:'JSON',
        success : function(obj) {
            console.log('검색성공');
            console.log($('.container__subTitle__select').val());
            getBoardListCallback(obj);                
        },           
        error : function(xhr, status, error) {}
        });

})


//게시글 불러오기 
function getBoardListCallback(obj){
	 const container__board__listview =document.querySelector('.container__board__listview');
    container__board__listview.innerHTML='';    
    var list = obj;
    var listLen = list.list.length


   if(listLen >  0){
    container__board__paging.innerHTML='';
        for(let i=0; i<listLen; i++){
            
            var bltTitle        = list.list[i].bltTitle; 
            var bltType         = list.list[i].bltType; 
            var bltDate         = list.list[i].bltDate; 
            var bltLike     = list.list[i].bltLike; 
            var bltCnt     = list.list[i].bltCnt; 
            var memberName     = list.list[i].memberName; 
            const itemRow =document.createElement('li');
            itemRow.setAttribute('class','item__row');
            if(bltType==='free')
            {
                bltType='자유';
            }
            else if(bltType==='qna')
            {
                bltType='질문';
            }
            else{
                bltType='구직';
            }
            console.log(bltType);
            itemRow.innerHTML=`
            <div class="container__board__list">
            <span class="container__board__type">${bltType}</span>
            <span class="container__board__title"><a href="contentview">${bltTitle}</a> </span>
            <span class="container__board__writer">${memberName}</span>
            <span class="container__board__date">${bltDate}</span>
            <span class="container__board__cnt"><i class="fas fa-eye"></i>${bltCnt}</span>
            <span class="container__board__like"><i class="fas fa-grin-hearts"></i>${bltLike}</span></div>`;  
            
            container__board__listview.appendChild(itemRow);
        } 
        for(let i=list.pagemaker.startPage; i<=list.pagemaker.endPage; i++){
            const pagingBtn = document.createElement('p');
            pagingBtn.setAttribute('class','paging');
            pagingBtn.setAttribute('data-id',`${i}`);
            pagingBtn.innerHTML=`${i}`;
            container__board__paging.appendChild(pagingBtn);
            
          }

        }
        else if(listLen==0){
            container__board__listview.innerHTML='';
            container__board__paging.innerHTML='';
        }
        
     else {
        
        console.log('게시글이없습니다.');
    }
    

}

