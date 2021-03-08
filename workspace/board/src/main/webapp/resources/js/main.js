'user script';
const arrowup__btn = document.querySelector('.arrowup__btn');
const header__logo = document.querySelector('.header__logo');
// 답글
const container__contentview__comment__content__replyBtn
=document.querySelector('.container__contentview__comment__content__replyBtn');
const container__contentview__comment__reply
=document.querySelector('.container__contentview__comment__reply');


container__contentview__comment__content__replyBtn.addEventListener('click', ()=>{
    if( container__contentview__comment__reply.style.display==='block')
    container__contentview__comment__reply.style.display='none';
    else{
        container__contentview__comment__reply.style.display='block';
    }
});

arrowup__btn.addEventListener('click',()=>{
    header__logo.scrollIntoView({behavior:"smooth"});
})