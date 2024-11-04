package telran.java53.edutrek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java53.edutrek.dto.GroupDto;
import telran.java53.edutrek.dto.ReminderDto;
import telran.java53.edutrek.service.GroupService;

@RestController
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {

	private final GroupService groupService;

	@Override
	public GroupDto addGroup(GroupDto groupDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto addReminder(String groupID, ReminderDto reminderDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto getGroupById(String groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GroupDto> getAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto updateGroupById(String groupID, GroupDto groupDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto addStudentToGroup(String groupID, List<String> studentsID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto moveStudentToGroup(String studentsID, String groupID, String groupIDNew) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto archiveGroup(String groupID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupDto removeStudentFromGroup(String studentsID, String groupID) {
		// TODO Auto-generated method stub
		return null;
	}
}
