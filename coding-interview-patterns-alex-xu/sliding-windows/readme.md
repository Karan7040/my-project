#Fixed Size Window Algorithm

left = right = 0;
while(right < n){
if(right - left + 1 == window_size){
process_sub_array();
left++;
}
right++;
}

#Dynamic Size Window Algorithm
left = right = 0;
while(right < n){
while(!condition){
left++;
}
result = process_window();
right++;
}