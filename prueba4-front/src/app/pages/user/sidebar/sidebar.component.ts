import { LoginService } from 'src/app/services/login.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidebar-user',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

 

  constructor(public login:LoginService) { }

  ngOnInit(): void {
    
  }

  public logout(){
    this.login.logout();
    window.location.reload();
  }

}
